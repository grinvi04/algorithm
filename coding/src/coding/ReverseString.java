/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package coding;/**
 * Created by grinvi on 2015-12-20.
 */
public class ReverseString {
    public static void main(String[] args) {
        String str = "i am a boy";

        System.out.println(str);
        System.out.println(reverse(str));
    }

    // 입력받은 문자열 역순으로 출력
    public static String reverse(String str) {
        char[] arr = str.toCharArray();
        char[] temp = new char[arr.length];

        for(int i = arr.length-1, ii = 0, j=0; i >= ii; i--, j++) {
            temp[j] = arr[i];
        }


        return String.valueOf(temp);
    }
}
