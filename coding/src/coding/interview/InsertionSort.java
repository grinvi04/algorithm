/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package coding.interview;/**
 * Created by grinvi on 2015-12-20.
 */



public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {5,2,4,6,1,3};

        sort(array);
        print(array);
    }

    public static void sort(int[] arr) {
        for(int i = 1, ii = arr.length; i < ii; i++) {
            print(arr);
            System.out.println();
            // 1. 좌측 인덱스의 값이 크면

            if(arr[i-1] > arr[i]) {
                //swap(arr, i-1, i);
                // 2. 시작위치부터 비교해서 우측 인덱스보다 값이 작은 위치에 삽입
                for(int j = 0, jj = i; j < jj; j++) {
                    if(arr[jj] < arr[j]) {
                        swap(arr, jj, j);
                    }
                }
            }

        }
    }

    public static int[] swap(int[] arr, int x, int y) {

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;

        return arr;
    }

    public static void print(int[] arr) {
        for(int i = 0, ii = arr.length; i < ii; i++) {
            System.out.print(arr[i]);
            if(i != ii-1) System.out.print(",");
        }
    }
}
