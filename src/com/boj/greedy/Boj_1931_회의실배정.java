package com.boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1931_회의실배정 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        int[][] schedules = new int[N][2];

        for(int i = 0; i < N; i++){
            String input = "";
            input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            // 저장
            schedules[i][0] = start;
            schedules[i][1] = end;


        }
        // 종료시간이 빠른 순으로 정렬
        Arrays.sort(schedules, (a, b) -> ((a[1] != b[1]) ? a[1] - b[1] : a[0] - b[0]));

        int count = 0;
        int endTime = 0; // 지금 시각
        for(int i = 0; i < N; i++){
            if(endTime <= schedules[i][0]){ // 이전 회의가 종료된 시각 <= 새로운 회의가 시작하는 시각
                count++;
                endTime = schedules[i][1]; // 종료시각 갱신
            }
        }

        System.out.println(count);

    }
}
