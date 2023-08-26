package com.boj.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_9742_순열2 {

    static char[] arr;
    static int count;
    static boolean[] visited;
    static int[] tmp;
    static StringBuilder sb;
    static int n;

    public static void permutation(int r, String str){

        // 종료조건
        if(str.length() == r){
            count++; // 현재 인덱스 증가
            if(count == n){
                System.out.println(str + " " + n + " = " + sb.toString());

            }

            return;
        }

        // logic
        for(int i = 0; i < str.length(); i++) {
            if(!visited[i]) {
                // 방문체크
                visited[i] = true;
                sb.append(arr[r]);

                // 방문
                permutation(r + 1, str);

                // 방문 후, 방문 해제
                visited[i] = false;
            }
        }


    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        while((input = br.readLine()) != null){
            /*
            String[] line = input.split(" ");
            String str = line[0]; // 문자열
            System.out.println(Arrays.toString(line));
            int n = Integer.parseInt(line[1]); // 찾는 인덱스
             */

            StringTokenizer st = new StringTokenizer(input);
            String str = st.nextToken();
            n = Integer.parseInt(st.nextToken());


            // 초기화 - 매 케이스마다 초기화
            arr = new char[str.length()];
            visited = new boolean[str.length()];
            count = 0;
            sb = new StringBuilder();

            arr = str.toCharArray();

            permutation(0, str); // 순열

/*
            if(n >= count){
                System.out.println(str + " " + n + " = " + sb.toString());

            }else{
                System.out.println("순열 불가능");
            }

 */
            if(n < count){
                System.out.println(str + " " + n + " = " + "순열 불가능");

            }


        }

    }
}
