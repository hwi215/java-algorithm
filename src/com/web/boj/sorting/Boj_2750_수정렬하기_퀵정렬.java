package com.web.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2750_수정렬하기_퀵정렬 {
    static int n;
    static int pivot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; // 배열

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        quickSort(arr, 0, n-1); // 퀵 정렬

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }

        pivot = partition(arr, left, right); // 피벗 값 찾기


        quickSort(arr, left, pivot-1); // 피벗 값을 기준으로 왼쪽 구간 퀵정렬
        quickSort(arr, pivot+1, right); // 피벗 값을 기준으로 오른쪽 구간 퀵정렬

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int left, int right) {
        // 배열의 left부터 right 까지 피벗을 기준으로 나누고, 최종 피벗 위치 반환
        // [start, end] -> [start ~ pivot-1], pivot, [pivot+1 ~ end]
        // left: 피벗보다 큰 값 찾기
        // right: 피벗보다 작은 값 찾기
        // swap

        int l = left+1;
        int r = right;
        pivot = arr[left];

        while(l <= r){ // left와 right가 엇갈릴 때까지 반복

            while (l <= r && arr[l] < pivot){ // 기준 값보다 큰 값이 나올때까지 left 1씩 증가
                l++;
            }
            while (l <= r && arr[r] > pivot){ // 기준 값보다 작은 값이 나올때까지 right 1씩 감소
                r--;
            }

            if (l < r){
                swap(arr, l, r);
            }


            //swap(arr, left, r);

        }
        // left와 right가 엇갈리면 right와 pivot값 교환

        swap(arr, left, r);


        return r;


    }



}
