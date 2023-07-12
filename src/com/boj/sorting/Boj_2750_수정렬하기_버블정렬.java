package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 버블정렬
 */
public class Boj_2750_수정렬하기_버블정렬 {
    static int n;

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr){

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++)
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        bubbleSort(arr);
        /*
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n-1; j++)
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
        }
         */

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }

    }


}
