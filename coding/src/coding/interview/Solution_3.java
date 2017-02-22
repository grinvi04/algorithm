/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package coding.interview;

import java.util.Stack;

/**
 * Created by grinvi on 2015-12-22.
 */
public class Solution_3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String str = "13 DUP 4 POP 5 DUP + DUP + -";

        Solution_3 a = new Solution_3();

        int val = a.solution(str);

        System.out.println(val);

    }

    public int solution(String S) {
        // write your code in Java SE 8
        String[] strArr = S.split(" ");

        if(strArr.length < 0 || strArr.length > 2000) return -1;

        Stack<Integer> stack = new Stack<Integer>();

        int minNum = 0;
        int maxNum = 1048575;

        for(int i = 0, ii = strArr.length; i < ii; i++) {

            if(isInteger(strArr[i])) {
                if(Integer.valueOf(strArr[i]) < minNum || Integer.valueOf(strArr[i]) > maxNum) return -1;

                stack.push(Integer.valueOf(strArr[i]));
            } else if("DUP".equals(strArr[i])){
                if(stack.isEmpty()) return -1;

                stack.push(stack.peek());
            } else if("POP".equals(strArr[i])){
                if(stack.isEmpty()) return -1;
                stack.pop();
            } else if("+".equals(strArr[i])){
                int first, next;

                if(!stack.isEmpty()) {
                    first  = stack.pop();
                } else {
                    return -1;
                }

                if(!stack.isEmpty()) {
                    next = stack.pop();
                } else {
                    return -1;
                }

                int sum = first + next;

                stack.push(sum);
            } else if("-".equals(strArr[i])){
                int first, next;

                if(!stack.isEmpty()) {
                    first  = stack.pop();
                } else {
                    return -1;
                }

                if(!stack.isEmpty()) {
                    next = stack.pop();
                } else {
                    return -1;
                }

                int sum = first - next;

                stack.push(sum);
            }

        }

        if(stack.isEmpty()) return -1;

        return stack.peek();
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
