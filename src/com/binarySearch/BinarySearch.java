package com.binarySearch;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        int find = Arrays.binarySearch(arr, 3);
        System.out.println(find);

        int find2 = Arrays.binarySearch(arr, 10000); // 존재하지 않으면? 음수로 나옴
        System.out.println(find2);
    }
}
