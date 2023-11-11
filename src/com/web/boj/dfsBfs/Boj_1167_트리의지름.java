package com.web.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1167_트리의지름 { // dfs

    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] visited;
    static int n;

    static class Node{
        int y;
        int len;

        public Node(int y, int len){
            this.y = y;
            this.len = len;
        }
    }

    static void dfs(int v){ //dfs
        visited[v] = true;

        for(Node node : graph[v]){
            if(!visited[node.y]) {
                visited[node.y] = true;
                distance[node.y] = distance[v] + node.len;
                dfs(node.y);
            }

        }
    }

    static int searchMax(int[] distance){
        int max = 0;
        int maxIndex = 0;
        for(int i = 1; i < n+1; i++){
            if(max < distance[i]){
                max = distance[i];
                maxIndex = i;
            }

        }
        return maxIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());


        // 초기화
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        distance = new int[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            int target = Integer.parseInt(input[0]);
            for(int j = 1; j < input.length-1; j += 2){
                int target2 = Integer.parseInt(input[j]);
                if(j % 2 != 0){
                    Node node = new Node(target2, Integer.parseInt(input[j+1]));
                    graph[target].add(node);
                }

            }
        }

        dfs(1); // 돌면서 distance  갱신하기


        int tar = searchMax(distance); // 가장 먼 index 찾기


        // 초기화
        visited = new boolean[n+1];
        distance = new int[n+1];

        dfs(tar); // 가장 거리가 먼 index로 다시 돌기


        System.out.println(distance[searchMax(distance)]);


    }
}
