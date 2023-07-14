package com.bruteForce;

/**
 * 조합
 * (순열을 조합으로 바꿔보기)
 * 이전에 선택한 인덱스 보다 큰 값민 뽑기
 */
public class Combination {
    static char[] arr;
    static int n; // 문자열 개수
    static int R; // 선택 개수
    static int[] select; // 선택저장변수
    static boolean[] isSelected; // 마킹배열


    public void combination(int size){ // 조합

        // 종료 조건
        if(size == R){
            return;
        }


        // 재귀 확장
        for(int i = 0; i < n; i++){
            if(!isSelected[i]){
                isSelected[i] = true;
                select[size] = i;
                combination(size+1);
                isSelected[i] = false;

            }
        }


    }
    public static void main(String[] args) {

        // 초기화
        arr = new char[] {'A', 'B', 'C', 'D'};
        n = arr.length;
        R = 2;
        select = new int[R];
        isSelected = new boolean[n];

        // 조합 실행
        combination(0);



    }
}
