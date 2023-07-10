package com.boj.arrayList;

import java.io.*;

public class Boj_2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int count = 0;
        for(int start = 1; start <= n; start++) {
            sum = start;
            for (int end = start + 1; end <= n; end++) {
                sum += end; // n보다 작으면 계속 더하기
                if (sum == n) { // n이 되면 종료
                    count += 1;
                    break;
                }else if(sum > n){
                    break;
                }

            }

        }
        System.out.println(count+1);

    }
}
