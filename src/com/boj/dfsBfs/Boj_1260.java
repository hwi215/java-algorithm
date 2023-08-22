package com.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260 {

    static int[][] graph;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int n;

    static void dfs(int i){
        System.out.print(i + " ");

        visited[i] = true;
        for(int j = 0; j <= n; j++){
            if(!visited[j] && graph[i][j] == 1){
                visited[j] = true;
                dfs(j);
            }

        }
    }

    static void bfs(int i){
        queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true; // 방문체크
        System.out.print(i + " ");

        while(!queue.isEmpty()){
            int target = queue.poll(); // 꺼내기
            for(int j = 0; j <= n; j++){
                if(!visited[j] && graph[target][j] == 1){
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        // n, m, v
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[n+1];
        graph = new int[n+1][n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start][end] = graph[end][start] = 1; // 연결 체크

        }

        dfs(v);

        System.out.println();

        visited = new boolean[n+1]; // 초기화
        bfs(v);


    }
}
