/*
 * Copyright (c) 2015. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package coding;

import java.util.Scanner;

/**
 * @author grinvi 사용자로부터 N 값을 입력받아서, N x N 격자의 칸들을 위와 같은 순서로 방문한 결과를 출력하는 프로그램을
 *         작성하세요. (단, N은 1부터 100 사이의 자연수)
 *
 */
public class Newhires_2015 {
    private static int[][] grid = null;

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // N값을 입력받는다.
        Scanner in  = new Scanner(System.in);
        int n = 0; // 격자를 생성할 N값

        do {
            System.out.print("N*N격자를 생성합니다. N값을 입력하세요(0 입력 시 종료) : ");
            n = in.nextInt();

            if(n == 0) System.exit(0);
        } while(n < 1 || n > 100);

        // 격자 배열 생성
        grid = new int[n][n];
        // 격자 크기 변수 선언
        int number = 0;

        // 격자 데이터 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = ++number;
            }
        }

        // 자리수 구하기(출력 포맷을 맞추기 위해서)
        int numberSize = 1;
        while(number > 0) {
            number = number / 10;
            numberSize++;
        }

        System.out.println("자릿수 : " + numberSize);


        // 격자 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf("%" + numberSize + "d", grid[i][j]);
            }
            System.out.println();
        }

        System.out.print("결과 : ");

        // 경로 탐색 시작
        initSearch(n-1);
    }

    /**
     * 초기 탐색 수행 함수
     * @param n 입력받은 격자 크기
     */
    public static void initSearch(int n) {
        // 입력받은 값으로 격자 탐색
        // 초기는 열 인덱스 감소하여 한 라인 탐색
        int i = 0;
        for(i = n; i >= 0; i--) {
            print(i, n);
        }

        //repeatSearch(i+1, n-1, n, "first");
        long start = System.currentTimeMillis ();
        repeatSearch(i+1, n-1, n, "first");
        //repeatSearch2(i+1, n-1, n);
        long end = System.currentTimeMillis ();

        System.out.println();
        System.out.println("걸린시간 : " + (end - start) / 1000.0);
    }

    /**
     * 배열 원소 탐색을 수행하는 재귀함수
     * @param x 시작 행 index
     * @param y 시작 열 index
     * @param count 유형을 반복할 변수
     * @param type 반복순서 유형 변수
     * @desc	// 반복순서
     * 			// 1. 열 인덱스 감소
     * 			// 2. 행 인덱스 증가
     * 			// 3. 열 인덱스 증가
     * 			// 4. 행 인덱스 감소
     * 			// 감소, 증가 시작범위는 param으로 받은 인덱스에서 시작해 count만큼 반복
     * 			// 1, 2가 한쌍, 3,4가 한쌍이고 함수가 한번 호출될 때 마다 count는 1감소
     */
    public static void repeatSearch(int x, int y, int count, String type) {
        if(count > 0) {	// 재귀호출 탈출 조건
            if("first".equals(type)) {
                for(int i = 0; i < count; i++) {
                    print(x, y--);
                }
                // 반복문 인덱스 처리로 인해 값 조정
                ++y;

                for(int i = 0; i < count; i++) {
                    print(++x, y);
                }

                // 반복문 인덱스 처리로 인해 값 조정
                ++y;

                // 재귀호출
                repeatSearch(x, y, --count, "second");
            } else {
                for(int i = 0; i < count; i++) {
                    print(x, y++);
                }

                // 반복문 인덱스 처리로 인해 값 조정
                --y;

                for(int i = 0; i < count; i++) {
                    print(--x, y);
                }

                // 반복문 인덱스 처리로 인해 값 조정
                --y;

                repeatSearch(x, y, --count, "first");
            }
        }
    }

    /**
     * 비재귀로 구현
     * @param x
     * @param y
     * @param count
     */
    public static void repeatSearch2(int x, int y, int count) {
        while(count > 0) {
            for(int i = 0; i < count; i++) {
                print(x, y--);
            }
            // 반복문 인덱스 처리로 인해 값 조정
            ++y;

            for(int i = 0; i < count; i++) {
                print(++x, y);
            }

            // 반복문 인덱스 처리로 인해 값 조정
            ++y;


            --count;

            for(int i = 0; i < count; i++) {
                print(x, y++);
            }

            // 반복문 인덱스 처리로 인해 값 조정
            --y;

            for(int i = 0; i < count; i++) {
                print(--x, y);
            }

            // 반복문 인덱스 처리로 인해 값 조정
            --y;

            --count;
        }
    }

    /**
     * 배열의 내용 출력
     * @param x
     * @param y
     */
    public static void print(int x, int y) {
        System.out.printf("%3d", grid[x][y]);
    }
}
