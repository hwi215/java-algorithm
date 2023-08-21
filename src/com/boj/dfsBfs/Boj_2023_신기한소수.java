package com.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_2023_신기한소수 {

    static int n;

    static void dfs(int num, int index){
        if(index == n){ // 백트래킹
            // n자리 모두 구하면
            if(checkPrime(num)){ // 소수인 경우 출력
                System.out.println(num);
            }
        }

        for(int i = 0; i < 10; i++){
            if(i % 2 == 0){ // 짝수면 무시,
                continue;
            }else{
                if(checkPrime(num*10 + i)){ // 소수인 경우
                    dfs((num*10 + i), index +1);
                }
            }
        }



    }
    public static boolean checkPrime(int num){ // 소수인지 확인

        for(int j = 2; j <= num/2; j++){
            if(num % j == 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); // 숫자 자리수

        // 7331 = 7, 73, 733, 7331


        // 한자리 소수 - 2, 3, 5, 7
        // 소수 가능성 - 1, 3, 5, 7, 9 (홀수)
        // -> 마지막 자리가 짝수이면 무조건 2로 나누어 떨어짐
        int[] targetOne = {2, 3, 5, 7};

        for(int i = 0; i < 4; i++) {
            dfs(targetOne[i], 1);
        }


    }
}
