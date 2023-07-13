package com.boj.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Boj_1729_수정렬하기_병합정렬 {

    public static void mergeSort(int[] arr, int[] tmp, int start, int end){


        // 1. 종료 조건
        if(start >= end){
            return;
        }

        // 2. 중앙값 계산
        int mid = (start + end) / 2;


        // 왼쪽 배열 분할
        mergeSort(arr,tmp, start, mid);
        // 오른쪽 배열 분할
        mergeSort(arr,tmp, mid+1, end);
        // 병합
        merge(arr, start, mid, end);



    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int leftIdx = left; // 왼쪽 idx
        int rightIdx = mid + 1; // 오른쪽 idx

        int[] tmp = new int[right+1]; // 임시 배열
        int currIdx = 0;


        while(leftIdx <= mid && rightIdx <= right){ // 끝까지 도달한 경우
            if(arr[leftIdx] <= arr[rightIdx]){
                tmp[currIdx] = arr[leftIdx]; // 작은값 넣기
                leftIdx++;
            }else{
                tmp[currIdx] = arr[rightIdx];
                rightIdx++;
            }
            currIdx++; // 값 추가후 인덱스 추가
        }

        if(leftIdx > mid){ // 왼쪽 정렬 끝인 경우 - 오른쪽 남은 부분 넣기
            for(int i = rightIdx; i <= right; i++){
                tmp[currIdx] = arr[i];
                currIdx++;
            }
        }else{ // 오른쪽 정렬 끝인 경우 - 왼쪽 남은 부분 넣기
            for(int i = leftIdx; i <= mid; i++){
                tmp[currIdx] = arr[i];
                currIdx++;
            }
        }


        // 원래 배열에 정렬 데이터 덮어씌우기
        for(int i = left; i <= right; i++){
            arr[i] = tmp[i - left];
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 배열
        int[] tmp = new int[n];


        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, tmp, 0, n-1); // 병합 정렬

        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
