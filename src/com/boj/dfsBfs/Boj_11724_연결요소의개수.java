package com.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * dfs 종료후 count += 1
 */
public class Boj_11724_연결요소의개수 {

    static boolean[] isVisited;
    static ArrayList<Integer>[] graph;
    static int count;
    static boolean check;

    static void dfs(int v){
        isVisited[v] = true;
        for(int next : graph[v]){
            if(!isVisited[next]){
                dfs(next);
                check = true;
            }
        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }


        for(int i = 0; i < M; i++){
            String input = br.readLine();
            StringTokenizer st2 = new StringTokenizer(input);
            int start  = Integer.parseInt(st2.nextToken());
            int end  = Integer.parseInt(st2.nextToken());

            // 그래프 생성
            graph[start].add(end);
            graph[end].add(start);

        }

        isVisited = new boolean[N+1];

        count = 0;
        check = false;
        for(int i = 1; i <=N; i++){
            if(!isVisited[i]){
                dfs(i);
                count++;
            }
        }

        System.out.println(count);

    }
}
