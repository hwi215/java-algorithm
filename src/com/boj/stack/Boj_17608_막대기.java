package com.boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boj_17608_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int target = 0;
        for(int i = 0; i < n; i++) {
            target = Integer.parseInt(br.readLine());
            while(!st.isEmpty() && check(st, target)){
                st.pop();
            }
            st.push(target);

            //System.out.println(st);

        }

        System.out.println(st.size());
    }
    public static boolean check(Stack st, int tmp){
        int t = (int) st.peek();

        return tmp >= t;
    }
}
