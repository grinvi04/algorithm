package baekjoon;

/**
 * Created by grinvi04 on 2017-02-22.
 */

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 문제 : 주어진 숫자들 중 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 입력 : 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 출력 : 주어진 수들 중 소수의 개수를 출력한다.
 * URL  : https://www.acmicpc.net/problem/1978
 */
public class Problem_1978_1 extends InputStream {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        int resultCnt = 0;
        int inputNum = 0;
        String[] inputStringArr;

        do {
            System.out.print("수의 개수를 하나만 입력하세요. : ");

            inputNum = Integer.valueOf(scan.next());
            inputStringArr = new String[inputNum];

            // 입력한 갯수만큼 숫자 입력
            System.out.print(inputNum + "개의 수를 입력하세요. : ");

            for(int i = 0, ii = inputNum; i < ii; i++) {
                inputStringArr[i] = scan2.next();
            }

            // 소수 판별
            resultCnt = getPrimeNumberCount(inputStringArr);
            System.out.println("소수 갯수 : " + resultCnt);

        } while(inputNum == 1);
    }

    public static int getPrimeNumberCount(String[] strArr) {
        int chkNum = 0;
        int count = 0;
        int m = 0;
        int n = 0;

        if(null == strArr || 0 > strArr.length) {
            return 0;
        } else {
            for(int i = 0, ii = strArr.length; i < ii; i++) {
                chkNum = Integer.valueOf(strArr[i]);

                if(chkNum == 1 || chkNum == 2) continue;
                else {
                    while(m == 0) {
                        m = chkNum / 2;
                        n = chkNum % 2;

                        if(m < 2 && n == 1) {
                            ++count;
                        } else {
                            chkNum = m;
                        }
                    }
                }
            }
            return count;
        }
    }

    @Override
    public int read() throws IOException {
        return 0;
    }
}
