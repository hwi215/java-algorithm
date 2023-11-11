package com.sorting;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Integer[] intArr = {8,7,6,5,4};
        Arrays.sort(intArr); // 오름차순 정렬

        Arrays.sort(intArr, Collections.reverseOrder()); // 내림차순 정렬
        // Collections.reverseOrder()
        int[][] routes = new int[5][5];

        // 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] route1, int[] route2){
                return route1[1] - route2[1];
            }

        });


        String[] str = new String[3];
        str[0] = "a";
        str[1] = "b";
        str[2] = "c";

        // 오름차순 정렬
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (a+b).compareTo(b+a);
            }

        });

        for(String s: str){
            System.out.print(s);
        }
        System.out.println();


        // 내림차순 정렬
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }

        });


        return;

    }
}
