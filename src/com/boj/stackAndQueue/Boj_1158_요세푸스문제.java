package com.boj.stackAndQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 원형큐
 * StringBuilder를 이용해서 마지막에 한 번만 출력하는 것이 효율적!!
 */
public class Boj_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        sb.append("<");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int count = 1;
        while(!q.isEmpty()){
            if(count == k){
                if(q.size() == 1){
                    sb.append(q.poll());

                }else {
                    sb.append(q.poll()).append(", ");
                }
                count = 1;

            }else{
                int target = q.poll();
                q.offer(target);
                count += 1;
            }

        }

        sb.append(">");

        System.out.println(sb);


    }
}
