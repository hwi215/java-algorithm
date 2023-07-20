package com.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1920_수찾기 {
    static int M;
    static StringTokenizer st2;
    static int[] arr;
    static String input;
    static String input2;
    static int target;
    static int find;

    static public void binarySearch(int target){ // 직접 구현
        int left = 0;
        int right = arr.length-1;

        int mid;

        while(left <= right){
            mid = (left + right) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else{
                System.out.println(1); // 값 찾음
                return;
            }

        }
        System.out.println(0);
        return;


    }

    static public void binarySearchAPI(int target){ // API 사용

        find = Arrays.binarySearch(arr, target);
        if(find >= 0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);


        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 정렬

        M = Integer.parseInt(br.readLine());
        input2 = br.readLine();
        st2 = new StringTokenizer(input2);

        for(int i = 0; i < M; i++){
            target = Integer.parseInt(st2.nextToken());

            binarySearch(target);
            //binarySearchAPI(target);


        }

    }
}
