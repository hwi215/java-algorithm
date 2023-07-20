package com.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2839_설탕배달 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int count = 0;
        boolean check = false;

        while(N >= 0){
            if(N == 0){
                check = true;
                break;
            }
            System.out.println(N + ", " + sum);

            if(N % 5 == 0){
                count += N / 5;
                check = true;
                break;
            }else{
                N -= 3;
                count++;
            }

        }


        if(check != true){
            System.out.println(-1);

        }else{
            System.out.println(count);

        }


    }
}
