package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2750_수정렬하기_퀵정렬 {
    static int n;
    static int pivaot, left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 배열

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        pivaot = arr[0]; // 첫 번째 값을 기준 피벗 값으로 설정

        quickSort(0, n-1);
    }

    private static void quickSort(int left, int right) {
        if(left >= right){
            return;
        }

        pivaot = partition(left, right);
        quickSort(left, pivaot-1);
        quickSort(pivaot+1, right);



    }

    private static int partition(int left, int right) { // 배열의 left부터 right 까지 피벗을 기준으로 나누고, 최종 피벗 위치 반환
        if(left >= right){
            return 0;
        }
        return pivaot;


    }



}
