package com.boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 해당 배열에 내가 찾는 수 있는 지 확인
 * -> 모두 확인하면 너무 오래걸리니까, 정렬 후 이분탐색 하기!
 */
public class Boj_1920 {

    static int[] arr;
    static int m;

    static void search(int target){

        int left = 0;
        int right = arr.length-1;

        while(left <= right) {

            int mid = (right + left) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
        return;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        arr = new int[n]; // n개 넣기
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr); // 이진탐색 -> 정렬 먼저!

        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){ // 찾아야하는 수 m개
            int target = Integer.parseInt(st.nextToken());

            // 이진탐색 시작
            search(target);

        }

    }
}
