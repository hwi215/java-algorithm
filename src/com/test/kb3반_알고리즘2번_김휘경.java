package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Long.sum;

/**
 * 세 수 합의 최대값?
 * 900001
 * 3 ~ 100 수 중에서 3개 뽑기 - 조합
 */
public class kb3반_알고리즘2번_김휘경 {

    static int[] arr;
    static int N; // 문자열 개수
    static int R; // 선택 개수
    static int[] select; // 선택저장변수
    static boolean[] isSelected; // 마킹배열
    static List<Integer> li;
    static int sum;
    static List<Integer> sumList = new ArrayList<>();


    public static void combination(int idx, int size){ // 조합

        // 종료 조건
        if(size == R){
            li = new ArrayList<>();
            sum = 0;


            if(select.length != 0) {
                for (int i = 0; i < select.length; i++) {
                    li.add(arr[select[i]]);
                    sum += arr[select[i]];
                }

                sumList.add(sum); // 합 담기
            }

            return;

        }


        // 재귀 확장
        for(int i = idx; i < N; i++){
            if(!isSelected[i]){
                isSelected[i] = true;
                select[size] = i;
                combination(i, size+1);
                isSelected[i] = false;

            }
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); // 주어진 숫자 개수
        int M = Integer.parseInt(line[1]); // 최대 숫자 합


        String[] tmp = br.readLine().split(" ");
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(tmp[i]);
        }

        // 조합 - 3개 뽑기
        R = 3;

        // 초기화
        select = new int[R];
        isSelected = new boolean[N];

        // 조합 실행
        combination(0, 0);

        Collections.sort(sumList, Collections.reverseOrder()); // 내림차순


        // 결과값 출력
       for(int i = 0; i < sumList.size(); i++){
            if(sumList.get(i) <= M){
                System.out.println(sumList.get(i));
                break;
            }

        }



    }
}
