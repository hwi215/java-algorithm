package com.stackAndQueue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 계속 push하다가 같으면 pop
 * 보다 크면 push
 */
public class B1874_스택수열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();
        List<String> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        int a = 1;
        int i = 0;
        int target; // 가장 최근에 pop한 값
        boolean check = true; // 수열 만들기 가능여부 check

        while(i < n){
            int t = Integer.parseInt(br.readLine());

            while(a <= t){
                stack.push(a);
                arr.add("+");
                a += 1;
            }

            target = stack.pop();
            arr.add("-");
            i += 1;

            if(target > t){ // 수열 만들기 불가능한 경우
                check = false;
                System.out.println("NO");
                break;
            }

        }

        if(check == true){ // 수열 만들기 가능하면, 해당 연산 출력
            for(int j = 0; j < arr.size(); j++){
                System.out.println(arr.get(j));
            }
        }


    }
}
