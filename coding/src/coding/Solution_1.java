/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package coding;

/**
 * Created by grinvi on 2015-12-22.
 */
public class Solution_1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Solution_1 a = new Solution_1();


        System.out.println(a.solution("a0Bb"));
    }

    public int solution(String S) {
        // write your code in Java SE 8
        char[] strArray = S.toCharArray();
        int length = strArray.length;


        int count = 0;
        int countSum = 0;
        boolean flag = false;

        for(int i = 0; i < length; i++ ) {
            int ascii = (int)strArray[i];


            if(flag) {
                count++;
            }

            if(ascii >= 65 && ascii <= 90) {
                if (flag) {
                    count--;

                    countSum += count;

                    count = 0;
                }

                flag = true;
                count++;
            }
        }

        countSum += count;

        return countSum;

    }
}
