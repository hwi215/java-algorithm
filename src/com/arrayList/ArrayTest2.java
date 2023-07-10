package com.arrayList;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest2 {
    public static void main(String[] args) {
        Test1();
        Test2();
    }

    private static void Test2() {
        // 배열 생성
        int[] arr = new int[]{100, 200, 300, 400, 500};
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 300){
                System.out.println(arr[i]);
            }
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 400){
                arr[i] = 999;
            }
        }
        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr); // 정렬
        System.out.println(Arrays.toString(arr));


    }

    private static void Test1() {

        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for(int i = 0; i < arr2.length; i++){
            for(int j = 0; j < arr2[i].length; j++){
                System.out.println(arr2[i][j]);
            }
        }

    }
}
