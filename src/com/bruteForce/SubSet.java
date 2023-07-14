package com.bruteForce;


/**
 * 부분집합 구현하기
 */
public class SubSet {
    static char[] arr; // 문자열 배열
    static int N; // 배열 크기
    static boolean[] isSelected; // 마킹 배열

    static void subset(int n){

        // 종료 조건
        if(n == N){
            for(int i = 0; i < N; i++){
                if(isSelected[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;

        }

        // 재귀 확장

        // 1) 선택하는 경우
        isSelected[n] = true;
        subset(n+1);

        // 2) 선택하지 않는 경우
        isSelected[n] = false;
        subset(n+1);


    }
    public static void main(String[] args) {
        arr = new char[] {'A', 'B', 'C', 'D'};
        N = arr.length;
        isSelected = new boolean[N];

        subset(0);
    }


}
