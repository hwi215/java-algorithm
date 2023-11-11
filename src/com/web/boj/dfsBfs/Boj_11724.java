package com.web.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 연결요소 구하기 - dfs
 * visited, graph
 */
public class Boj_11724 {

    static boolean[] visited; // 방문체크
    static ArrayList<Integer>[] graph;

    static int count;
    public static void dfs(int index){
        visited[index] = true;
        for(int next : graph[index]){
            if(!visited[next]){
                dfs(next);
            }

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st0 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st0.nextToken());
        int m = Integer.parseInt(st0.nextToken());


        graph = new ArrayList[n+1];
        // graph 초기화
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) { // m줄 입력받기
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);

        }

        visited = new boolean[n+1];
        count = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                dfs(i);
                count++;
            }

        }

        System.out.println(count);
    }
}
