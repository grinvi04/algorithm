/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package coding.interview;

/**
 * Created by grinvi on 2015-12-22.
 */
public class Solution_2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int N = 2147483647;

        Solution_2 a = new Solution_2();

        int count = a.solution(N);

        System.out.println(count);

    }

    public int solution(int N) {
        // write your code in Java SE 8
        int count = 0;

        while(N >= 1) {
            if((N % 2) == 0) N = N / 2;
            else N = N - 1;

            count++;
        }

        return count;
    }
}
