package com.bruteForce;

/**
 * 순열
 * - 재귀 이용
 * - 중복허용, nPr
 * - ex) 중복허용하여 2개 뽑기
 */
public class Permutation {
    static char[] arr;
    static int N;
    static int R;
    static int[] select;

    // 중복 순열
    public static void dupPermutation(int r){

        // 종료 조건 - n개 선택하면 종료
        if(r == R){
            for(int i =0;i < select.length; i++){
                System.out.print(arr[select[i]]);
            }
            System.out.println();
            return;
        }

        // 재귀 확장
        for(int i = 0; i < arr.length; i++){
            select[r] = i;
            dupPermutation(r+1);

        }

    }
    public static void main(String[] args) {
        arr = new char[] {'A', 'B', 'C', 'D'};
        N = 4;
        R = 2;

        select = new int[R];

        dupPermutation(0);





    }
}
