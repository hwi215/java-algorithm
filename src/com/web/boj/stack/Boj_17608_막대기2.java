package com.web.boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_17608_막대기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int target = 0;

        for (int i = 0; i < n; i++) {
            st.push(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        while (!st.isEmpty()) {
            int tmp = st.pop();
            if (target < tmp) {
                count += 1;
                target = tmp;
            }

        }
        System.out.println(count);
    }
}

