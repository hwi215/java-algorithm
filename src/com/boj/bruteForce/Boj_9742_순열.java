package com.boj.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9742_순열 {

    static char[] arr;
    static int R; // 문자열 길이
    static int[] select;
    static boolean[] isSelected;
    static String result; // 출력 문자열 저장
    static int n; // 찾고자하는 순열 번호
    static int count; // 순열 번호

    private static void permutation(String str, int r){
        if(r == str.length()){
            count++; // 순열 수 갱신
            if(count==n) {
                result = new String(arr);
            }
            return;
        }

        for(int i=0; i < str.length(); i++){ // 순열
            if(!isSelected[i]){
                isSelected[i]=true;
                arr[r]=str.charAt(i);
                permutation(str, r+1);
                isSelected[i]=false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line);
            String s = st.nextToken();
            n = Integer.parseInt(st.nextToken());

            count = 0;
            arr = s.toCharArray();
            R = s.length();

            // 초기화
            select = new int [R];
            isSelected = new boolean [R];


            permutation(s, 0);

            if(count < n){ // 해당 순열이 존재하지 않는 경우
                result = "No permutation";
            }

            System.out.println(s + " " + n + " = " + result);


        }

    }
}
