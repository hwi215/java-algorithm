package com.boj.arrayList;

import java.io.*;

public class Boj_11720_숫자의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split("");

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += Integer.parseInt(s[i]);
        }

        System.out.println(sum);

        br.close();
        bw.flush();
        bw.close();

    }
}
