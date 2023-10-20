package com.web.programmers.BfsDfs;

import java.util.*;
class 게임맵최단거리 {
    static int count = 0;
    static boolean[][] isVisited;
    static int n;
    static int m;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        isVisited = new boolean[n][m];
        return bfs(0, 0, 0, maps);

    }

    public int bfs(int x, int y, int count, int[][] maps){

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1)); // 큐에 넣기
        isVisited[x][y] = true; // 방문체크

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while(!queue.isEmpty()){
            // 꺼내기
            Node node = queue.poll();

            if(node.x == n-1 && node.y == m-1){
                return node.count;
            }

            for(int i = 0; i < 4; i++){
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m){ // 이동 가능한 경우
                    if(!isVisited[nx][ny] && maps[nx][ny] == 1){
                        // 넣기
                        queue.offer(new Node(nx, ny, node.count+1));
                        isVisited[nx][ny] = true; // 방문체크
                    }

                }
            }

        }

        return -1;
    }
}

class Node{
    int x;
    int y;
    int count;

    Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}