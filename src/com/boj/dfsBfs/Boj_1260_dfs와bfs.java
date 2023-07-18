package com.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * dfs 스택으로도 구현해보기
 * 방문처리 들어오자마자로 바꿔보기(성능은 좀 더 안좋음)
 */
public class Boj_1260_dfs와bfs {
    static boolean[] isVisited;
    static int N;
    static int M;
    static int startV; // 시작점
    static int[][] graph;

    // dfs - 1. 재귀로 구현
    static void dfs(int v) {
        isVisited[v] = true; // 방문 처리
        System.out.print(v + " ");

        for(int i = 1; i <= N; i++) {
            if(graph[v][i] == 1 && isVisited[i] == false) {
                dfs(i); // 재귀
            }
        }
    }

    // dfs - 2. 스택으로 구현
    static void dfsStack(){

    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startV); // 시작점 큐에 넣고 시작
        isVisited[startV] = true; // 방문 처리
        System.out.print(startV + " ");

        while(!queue.isEmpty()){
            int target = queue.poll(); // 꺼내기

            // **들어가자마자 마킹해도 됨
            for(int i = 1; i <= N; i++){
                if(isVisited[i] == false && graph[target][i] == 1){
                    queue.offer(i); // 큐에 넣기
                    isVisited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        startV = Integer.parseInt(input[2]);

        // 초기화
        isVisited = new boolean[N+1];
        graph = new int[N+1][N+1];

        // 그래프 설정
        for(int i = 0; i < M; i++){
            String[] input2 = br.readLine().split(" ");
            int v1 = Integer.parseInt(input2[0]);
            int v2 = Integer.parseInt(input2[1]);

            // 양방향 간선 연결
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        dfs(startV);

        // 초기화
        isVisited = new boolean[N+1];
        System.out.println();

        bfs();
    }
}
