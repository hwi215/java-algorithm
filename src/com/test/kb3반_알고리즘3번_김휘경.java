package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [승리하는 법]
 * 같은 색 바둑알 연속으로 5개 놓인 경우
 * 박 - 검은 1
 * 문 - 흰 2
 * 바둑알 없음 - 0
 *
 * [출력값]
 * 박 > 문 : 1
 * 박 < 문 : 2
 * 박 = 문 : 0
 *
 * 둘 중 한명이 이긴 경우, 연속 다섯 바둑알의 가장 왼쪽에 놓인 바둑알 위치 (가로, 세로) 출력 - 첫줄 1
 *
 * [예외처리]
 * 여섯 알 이상 연속으로 놓인경우는 이긴 것이 아님
 * 동시에 이기는 경우는 없음
 */
public class kb3반_알고리즘3번_김휘경 {
    static int N = 19; // 바둑판 가로
    static int M = 19; // 바둑판 세로
    static int[][] map = new int[N][M];
    static boolean check1;
    static boolean check2;
    static boolean check3;
    static boolean check;
    //static int beforeScore;
    static int[] answer = new int[2]; // 박연진 인덱스 배열
    static int[] answer2 = new int[2]; // 문동은 인덱스 배열


    public static boolean check1(int target){ // 가로 확인
        //System.out.println("check1");
        check1 = false;
        int count = 0;

        for(int i = 0; i < N; i++){
            count = 0;
            for(int j = 0; j < M-1; j++){

                if(map[i][j] == map[i][j+1]){ // 연속 바둑알인 경우
                    if(map[i][j] == target){
                        count += 1;  // 연속 바둑알 횟수
                        if(count == 1) {
                            if(target == 1){
                                answer[0] = i + 1;
                                answer[1] = j + 1;
                            }else if(target == 2){
                                answer2[0] = i + 1;
                                answer2[1] = j + 1;
                            }

                        }
                    }else{
                        count = 0;
                    }
                }else{
                    count = 0; // 연속 바둑알 리셋
                }

                //System.out.println(i + ", " + j + ", " + count);

                if(count == 4){
                    check1 = true;
                    //System.out.println("check1: " + answer[0] + ":::" + answer[1]);

                    return check1;
                }
            }
        }
        return check1;

    }

    static boolean check2(int target){ // 세로 확인
        //System.out.println("check2");
        check2 = false;

        int count = 0;

        for(int j = 0; j < M; j++){
            count = 0;
            for(int i = 0; i < N-1; i++){

                if(map[i][j] == map[i+1][j]){ // 연속 바둑알인 경우
                    if(map[i][j] == target){
                        count += 1;  // 연속 바둑알 횟수
                        if(count == 1) {
                            if(target == 1){
                                answer[0] = i + 1;
                                answer[1] = j + 1;
                            }else if(target == 2){
                                answer2[0] = i + 1;
                                answer2[1] = j + 1;
                            }
                            //System.out.println("check2: " + answer[0] + ":::" + answer[1]);
                        }
                    }else{
                        count = 0;
                    }

                }else{
                    count = 0; // 연속 바둑알 리셋
                }

                if(count == 4){
                    check2 = true;

                    return check2;
                }
            }
        }
        return check2;

    }

    static boolean check3(int target){ // 대각선 확인
        //System.out.println("check3");
        check3 = false;
        int beforeScore = 0;
        int count = 0;

        for(int i = 0; i < N-1; i++){
            for(int j = 0; j < M-1; j++){
                if(map[i][j] == map[i+1][j+1]){ // 연속 바둑알인 경우
                    if(map[i][j] == target){
                        count += 1;  // 연속 바둑알 횟수
                        if(count == 1) {
                            if(target == 1){
                                answer[0] = i + 1;
                                answer[1] = j + 1;
                            }else if(target == 2){
                                answer2[0] = i + 1;
                                answer2[1] = j + 1;
                            }
                            //System.out.println("check3: " + answer[0] + ":::" + answer[1]);
                        }
                    }else{
                        count = 0;
                    }
                }else{
                    count = 0; // 연속 바둑알 리셋
                }

                if(count == 4){
                    check3 = true;

                    return check3;
                }
            }
        }
        return check3;

    }

    static boolean isSuccess(int target){ // 성공했는지 확인
        boolean check = false;

        if(check1(target)){
            check = true;
            return check;
        }else if(check2(target)){
            check = true;
            return check;
        }else if(check3(target)){
            check = true;
            return check;
        }

        return check;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 바둑판 초기화
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                int t = Integer.parseInt(line[j]);
                map[i][j] = t;
                //System.out.print(map[i][j]);
            }
        }

        // 가로 or 세로 or 대각선 승리
        boolean park = isSuccess(1);
        boolean moon = isSuccess(2);

        //System.out.println(park + ", " + moon);


        // 결과값 출력
        if(park && !moon){ // 박 > 문
            System.out.println("1");
            System.out.println(answer[0] + " " + answer[1]);

        }else if(!park && moon){ // 박 < 문
            System.out.println("2");
            System.out.println(answer2[0] + " " + answer2[1]);

        }else{
            System.out.println("0");
        }


    }
}

/**
 * 배열 크기 = 20
 * arr[y][x]
 * 오목이 성립되는 경우 -> 6목 체크하기!!- > 앞 / 뒤 모두 체크하기!!
 *
 */