package com.web.boj.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * left : 최대값, right : 전체 합
 * mid = (left + right) / 2
 * 블루레이 갯수 확인하면서,
 *
 * while(left <= right)
 * 블루레이 갯수가 m보다 큰 경우 -> left = mid + 1
 *                 작은 경우 -> right = mid - 1
 *
 */
public class Boj_2343_기타레슨 {

    static int[] arr;
    static int n;
    static int m;

    static int checkCount(int mid){

        int sum = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            if((sum + arr[i] > mid)){
                // 리셋
                sum = 0;
                count++;
            }
            sum += arr[i];

        }

        if(sum != 0){
            count++; // 남아있으면 하나 추가
        }
        return count;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        String[] input = br.readLine().split(" ");

        arr = new int[n];
        int left = 0; // 최대값
        int right = 0; // total
        int max = 0;
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
            right += arr[i];
            /*
            if(max < arr[i]){ // 최대값 찾기
                max = arr[i];
            }

             */
            max = Math.max(max, arr[i]); // Math.max 이용하기
        }

        left = max;

        //Arrays.sort(arr); - 여기선 순서 변경하지 말라고 했으므로 정렬없이 이분탐색 진행


        while(left <= right){
            int mid = (left + right) / 2; // 중간값
            int count = checkCount(mid); // 블루레이 갯수 구하기

            if(count > m){ // 지정된 블루레이 갯수보다 큰 경우
                left = mid + 1; //
            }else{
                right = mid -1;
            }
        }

        System.out.println(left); // left가 최대값이니까


    }
}
