package com.web.boj.dfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 최소 칸 수 = bfs -> queue
 */
public class Boj_2178 {

    static int[][] graph;
    static boolean[][] visited;
    static int n;
    static int m;
    static Queue<Node> queue;
    static int count;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Node {
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    static boolean check(Node node){
        int x = node.x;
        int y = node.y;

        if(x >= 0 && x <= n && y >= 0 && y <= m){
            return true;
        }else{
            return false;
        }

    }

    static void bfs(int x, int y){

        queue.offer(new Node(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            if(x == n && y == m){
                return;
            }

            Node node = queue.poll();
            int nx = node.x;
            int ny = node.y;
            visited[nx][ny] = true;

            for(int i = 0; i < 4; i++){
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                if(check(new Node(nextX, nextY)) && graph[nextX][nextY] == 1 && !visited[nextX][nextY]){
                    visited[nextX][nextY] = true; // 방문체크
                    queue.offer(new Node(nextX, nextY));
                    graph[nextX][nextY] += graph[nx][ny];
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){ // 그래프 생성
            String[] input = br.readLine().split("");
            for(int t = 0; t < input.length; t++){
                graph[i][t+1] = Integer.parseInt(input[t]);
            }
        }

        queue = new LinkedList<>(); // 초기화
        visited = new boolean[n+1][m+1];
        count = 1;
        bfs(1, 1);

        System.out.println(graph[n][m]);

    }
}
