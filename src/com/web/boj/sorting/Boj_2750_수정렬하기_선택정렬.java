package com.web.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2750_수정렬하기_선택정렬 {
    static int n;

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void selectionSort(int[] arr){
        int minIdx = 0;
        
        for(int i = 0; i < n-1; i++){
            minIdx = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[minIdx]){
                    minIdx = j; // 최솟값 갱신
                }
            }
            swap(arr, minIdx, i);
        }
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        selectionSort(arr);

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

    }


}
