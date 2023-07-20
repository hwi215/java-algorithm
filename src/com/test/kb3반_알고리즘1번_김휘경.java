package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class kb3반_알고리즘1번_김휘경 {

    static int n;

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selectionSort(int[] arr){ // 선택정렬 - 내림차순
        int maxIdx = 0;

        for(int i = 0; i < n-1; i++){
            maxIdx = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] > arr[maxIdx]){
                    maxIdx = j; // 최대값 갱신
                }
            }
            swap(arr, maxIdx, i);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        selectionSort(arr); // 선택정렬

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

    }



}
