/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package coding.interview;

import java.io.*;
import java.util.*;

/**
 * @author grinvi
 *
 * 아래 명세를 참고하여 "영어 단어 맞추기" 프로그램을 작성하세요.
 * 5글자 이상의 영어 단어를 10개 이상 고른다
 * 이 단어들은 교체가 쉬운 형태로 저장해둔다 (재컴파일 등이 필요하지 않아야 함)
 * 프로그램을 시작하면 단어 하나를 랜덤하게 고른다 (예: synapsoft)
 * 그 단어의 글자 수만큼 별표(*)를 출력한다 (예: *********)
 * 사용자로부터 알파벳 소문자(a-z) 글자를 하나 입력받는다
 * 알파벳 소문자가 아니거나, 이전에 이미 입력했던 글자면 다시 입력받는다
 * 입력한 글자가 현재 단어에 들어 있으면
 * 단어 내 출현한 위치에 별표 대신 해당 글자를 넣어서 출력한다
 * 예를 들어 's'를 입력받았을 경우: s****s*** 처럼 표시
 * 만약 모든 글자를 맞추었으면 끝낸다
 * 들어있지 않으면 틀린 횟수를 하나 증가시킨다
 * 7번 틀렸으면 끝낸다
 * 사용자로부터 다시 다음 문자를 입력받는다
 * 명세되지 않은 부분은 나름대로 가정을 세워서 구현하시고, 그 내용을 같이 보내주시면 됩니다.
 */
public class Career_2015 extends InputStream {
    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub




        FileReader fileReader = null;
        try {
            // 파일 생성 부분 추가 필요 20151222
            // 파일 생성(R/W) 및 초기 데이터 추가한다.
            // 한글좀 그만 꺠져라..
            // 아좀..
            // 다시 테스트
            // 다시..
            fileReader = new FileReader("D:/wordList.txt");
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            System.out.println("파일을 찾을 수 없습니다.");
            System.exit(-1);
        }

        BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(fileReader);

        StringBuffer stringBuffer = null;
        String line = null;

        ArrayList<String> wordList = new ArrayList<String>();

        try {
            while((line = bufferedReader.readLine()) != null) {
                stringBuffer = new StringBuffer();

                stringBuffer.append(line);

                wordList.add(stringBuffer.toString());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("파일을 읽는 중 오류가 발생하였습니다.");
            System.exit(-1);
        }


        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        String temp = wordList.get(randomIndex);


        char[] randomChar = temp.toCharArray();
        char[] encChar = new char[randomChar.length];


        System.out.println(String.valueOf(randomChar));

        for(int i = 0; i < randomChar.length; i++) {
            encChar[i] = '*';
        }

        System.out.println(String.valueOf(encChar));


        Career_2015  cc = new Career_2015();
        Scanner in = new Scanner(System.in);

        char inputChar = 0;
        boolean isContain = false;
        boolean isExists = false;
        int ascii = 0;
        int errorCount = 0;


        Map<Character, Boolean> inputCharMap = new HashMap<Character, Boolean>();
        Map<Character, ArrayList<Integer>> changeCharMap = new HashMap<Character, ArrayList<Integer>>();

        do {
            System.out.print("알파벳 소문자를 입력하세요. : ");

            try {
                inputChar = (char)cc.read();
                ascii = (int)inputChar;



                // 입력한 문자가 이미 입력한 문자인지 체크
                if(inputCharMap.containsKey(inputChar)) {
                    System.out.println("입력했던 문자입니다. 다시 입력해주세요.");
                    isContain = true;
                } else inputCharMap.put(inputChar, true);

                // 입력한 글자가 선택한 단어에 포함되는지 체크
                changeCharMap = cc.isChangeChar(randomChar, inputChar);
                if(!changeCharMap.isEmpty()) {
                    cc.changeChar(encChar, changeCharMap, inputChar);

                    System.out.println(String.valueOf(encChar));

                    if(String.valueOf(randomChar).equals(String.valueOf(encChar))) {
                        System.out.println("모두 맞히셨습니다. 종료합니다.");
                        System.exit(-1);
                    }
                } else {
                    errorCount++;
                    System.out.println(errorCount + "번 틀리셨습니다.");
                }




            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } while((ascii < 97 || ascii > 122) || isContain || errorCount < 7);

        System.out.println("종료");
    }

    /**
     * 입력한 문자를 원본 문자열에서 찾아 문자와 인덱스를 map으로 반환
     * @param charArray
     * @param ch
     * @return
     */
    public Map<Character, ArrayList<Integer>> isChangeChar(char[] charArray, char ch) {
        Map<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
        ArrayList<Integer> indexList = new ArrayList<Integer>();

        for(int i = 0, ii = charArray.length; i < ii; i++) {
            if(charArray[i] == ch) {
                indexList.add(i);
            }
        }

        if(!indexList.isEmpty()) map.put(ch, indexList);

        return map;
    }

    /**
     * 입력한 문자를 바꿀 문자열에서 찾아서 변환
     * @param charArray
     * @param map
     * @param ch
     */
    public void changeChar(char[] charArray, Map<Character, ArrayList<Integer>> map, char ch) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list = map.get(ch);

        for (Integer integer : list) {
            charArray[integer] = ch;
        }
    }

    @Override
    public int read() throws IOException {
        // TODO Auto-generated method stub
        int c;

        do {
            c = System.in.read();
        } while(c != -1 && (c == '\n' || c == '\r'));

        return c;
    }
}
