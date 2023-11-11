package com.web.boj.binarySearch;

import java.util.Scanner;

/**
 * i * j 를 리스트에 넣은 후, 오름차순 정렬
 * 정렬 한 리스트에서 k번째 찾기 -> 큰 수부터 k번째 수 찾기 ==> 시간초과
 *
 * 이진탐색 - log(N)
 *
 * 중앙값보다 작은 수의 개수가 k-1개인 중앙값 찾기!!!
 * - k-1개보다 크면?
 */
public class Boj_1300_K번째수 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int l = 1;
        int r = k;
        int result = 0;
        while(l <= r) {
            int mid = (l + r) / 2;
            long count = 0;

            // 중앙값보다 작은 수의 갯수 구하기
            for(int i = 1; i <= n; i++) {
                count += Math.min(mid / i, n);
            }

            if(count < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
                result = mid;
            }
        }
        System.out.println(result);
    }
}
