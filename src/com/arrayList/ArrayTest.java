package com.arrayList;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 배열 사용하기
 */
public class ArrayTest {
    public static void main(String[] args) {


        int [] arr = new int [10];

        for(int i = 0; i < 10; i++){
            arr[i] = i;
        }

        // 배열 값 출력
        System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        // (배열, 변경 값)
        Arrays.fill(arr, 100);
        System.out.println(Arrays.toString(arr)); // [100, 100, 100, 100, 100, 100, 100, 100, 100, 100]

        // 배열 값을 원하는 값으로 초기화
        arr = new int [] {5, 4, 3, 2};
        System.out.println(Arrays.toString(arr));


        // 정렬
        Arrays.sort(arr); // 오름차순 정렬
        System.out.println("정렬");
        System.out.println(Arrays.toString(arr));

        // 슬라이싱
        Arrays.copyOfRange(arr, 1, 3); // (배열, 시작인덱스, 마지막 인덱스)
        System.out.println(Arrays.toString(arr));


        //2차원 배열

        int [][] arr2d = {{1, 2}, {2, 3}, {5,2}};
        System.out.println(Arrays.toString(arr2d));

        // 2ck차원 배열 - for문으로 출력
        for(int i = 0; i < arr2d.length; i++){
            System.out.println(Arrays.toString(arr2d[i])); // 출력하는 법 1
        }
        System.out.println(Arrays.deepToString(arr2d)); // 출력하는 법 2


    }







}
