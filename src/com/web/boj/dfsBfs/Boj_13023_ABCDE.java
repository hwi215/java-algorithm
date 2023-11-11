package com.web.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


/**
 * 1) 모든 노드를 탐색해야 함 -> 어떤 점에서는 조건 만족이 안될 수 있으니까
 * 2) 백트레킹(dfs + 재귀)
 *
 * - 마킹배열 해제 표현
 * - 5개가 일렬로 저장되어 함
 * - 3) count 변수(static 변수)
 * 양뱡향
 *
 */
public class Boj_13023_ABCDE {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static boolean check;

    static void dfs(int index, int depth){
        if(depth == 5 || check == true){
            check = true;
            return;
        }

        visited[index] = true; // 방문체크
        for(int next : graph[index]){
            if(!visited[next]){
                dfs(next, depth+1);
            }
        }
        visited[index] = false; // 해제

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 초기화
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            graph[start].add(end);
            graph[end].add(start);

        }


        // 초기화
        check = false;
        for(int i = 0; i < n; i++){ // 모든 노드 탐색
            dfs(i, 1);
        }

        if(check == true){
            System.out.println(1);
        }else{
            System.out.println(0);
        }



    }
}


