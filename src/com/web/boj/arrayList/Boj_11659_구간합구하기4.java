package com.web.boj.arrayList;

import java.io.*;

public class Boj_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] input = s.split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int answer = 0;

        String[] arr = br.readLine().split(" ");
        int[] sum = new int[n];

        sum[0] = Integer.parseInt(arr[0]); // 누적합 초기화
        for(int i = 1; i < n; i++){
            sum[i] = sum[i-1] + Integer.parseInt(arr[i]); // 누적합
        }

        for(int i = 0; i < m; i++){
            String[] target = br.readLine().split(" ");
            int start = Integer.parseInt(target[0]);
            int end = Integer.parseInt(target[1]);

            if(start == 1){
                answer = sum[end-1];
            }else {
                answer = sum[end - 1] - sum[start - 2];
            }

            System.out.println(answer);

        }

        br.close();
        bw.flush();
        bw.close();

    }
}
