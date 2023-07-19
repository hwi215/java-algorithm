package com.boj.dfsBfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최단시간 찾기 -> bfs + dp문제인듯?
 *
 * 1초 후 이동 - 위치:X일때,
 * 걷기 : (x-1) or (x+1)
 * 순간이동 : 2*X
 */
public class Boj_1697_숨바꼭질 { // bfs + dp 문제

    static int N;
    static int K;
    static int dp[];
    static int target;
    static boolean[] isVisited;
    static Queue<Integer> queue;

    static void bfs(int x){

        queue.offer(x); // 현재 위치 큐에 넣기
        isVisited[x] = true; // 방문체크

        while(!queue.isEmpty()) {

            if(x == K){ // 중단조건(동생 만남)
                break;
            }

            x = queue.poll();


            // x - 1
            target = x - 1;
            if (target >= 0 && target < 100001 &&  !isVisited[target]) { // 가능한 범위 && 방문하지 않은 경우
                isVisited[target] = true; // 방문체크
                dp[target] = dp[x] + 1; // dp 갱신
                queue.offer(target);
            }


            // x + 1
            target = x + 1;
            if (target >= 0 && target < 100001 && !isVisited[target]) {
                isVisited[target] = true; // 방문체크
                dp[target] = dp[x] + 1; // dp 갱신
                queue.offer(target);
            }

            // x * 2
            target = x * 2;
            if (target >= 0 && target < 100001 && !isVisited[target]) {
                isVisited[target] = true; // 방문체크
                dp[target] = dp[x] + 1; // dp 갱신
                queue.offer(target);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        N = Integer.parseInt(st.nextToken()); // 수빈 처음 위치
        K = Integer.parseInt(st.nextToken()); // 동생 처음 위치


        // 초기화
        dp = new int[100001];
        isVisited = new boolean[100001];
        queue = new LinkedList<>();

        for(int i = 0; i < 100001; i++){
            dp[i] = 1;
        }


        // 수빈 처음 위치에서 시작
        bfs(N);
        System.out.println(dp[K]-1);


    }
}
