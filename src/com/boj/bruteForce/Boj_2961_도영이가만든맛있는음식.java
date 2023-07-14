package com.boj.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * 신맛 - 곱
 * 쓴맛 - 합
 * 차이 가장 작은 요리 만들기
 * 부분집합 이용한 문제!!!
 * 1~n개 조합 구해서 (n1끼리 곱하기) - (n1끼리 더하기)= 차이가장 작은거
 */
public class Boj_2961_도영이가만든맛있는음식 {

    static int[] arr;
    static int[] arr1;
    static int[] arr2;
    static boolean[] isSelected; // 마킹배열
    static int n;
    static int minus;
    static List<Integer> t;


    static void subset(int size){

        List<Integer> result;

        // 종료 조건
        if(size == n){
            minus = 1000000001;
            result = new ArrayList<>(); // 초기화

            for(int i = 0; i < n; i++){
                if(isSelected[i]){
                    result.add(arr[i]); // 부분집합 하나
                }
            }

            if(result.size() != 0) {
                int total1 = 1;
                int total2 = 0;

                for (int i = 0; i < result.size(); i++) {
                    int idx = result.get(i);
                    total1 *= arr1[idx - 1]; // 신맛
                    total2 += arr2[idx - 1]; // 쓴맛
                }
                minus = min(minus, abs(total1 - total2));

            }

            if(t.size() > 0){
                if(t.get(t.size()-1) > minus) {
                    t.add(minus);
                }
            }else{
                t.add(minus);
            }

            Collections.sort(t);

            return;

        }

        // 재귀 확장 - 부분집합

        // 1) 선택하는 경우
        isSelected[size] = true;
        subset(size+1);

        // 2) 선택하지 않는 경우
        isSelected[size] = false;
        subset(size+1);


    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = new ArrayList<>();
        n = Integer.parseInt(br.readLine());// 재료의 개수

        arr = new int[n];
        arr1 = new int[n];
        arr2 = new int[n];

        for(int i = 0; i < n; i++){
            // 신맛 쓴맛
            String[] input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);

            arr1[i] = n1;
            arr2[i] = n2;

            arr[i] = i+1;

        }


        // 초기화
        isSelected = new boolean[n];


        subset(0); // 부분집합으로 값 처리

        System.out.println(t.get(0)); // 가장 작은 값


    }
}
