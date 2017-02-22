package baekjoon;

/**
 * Created by grinvi04 on 2017-02-22.
 */

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

/**
 * 문제 : 주어진 숫자들 중 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 입력 : 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 출력 : 주어진 수들 중 소수의 개수를 출력한다.
 * URL  : https://www.acmicpc.net/problem/1978
 */
public class Problem_1978_1 extends InputStream {
    public static void main(String[] args) {
        System.out.print("알파벳 소문자를 입력하세요. : ");

        char inputChar = 0;

        Problem_1978_1 cc = new Problem_1978_1();

        try {
            inputChar = (char)cc.read();

            System.out.println(inputChar);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
