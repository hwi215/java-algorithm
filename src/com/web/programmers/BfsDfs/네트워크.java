package com.web.programmers.BfsDfs;

public class 네트워크 {
    class Solution {

        static boolean[] isVisited;
        public int solution(int n, int[][] computers) {
            int count = 0;
            isVisited = new boolean[n];

            for(int i = 0; i < n; i++){
                if(!isVisited[i]){
                    dfs(i, computers);
                    count += 1;
                }
            }
            return count;
        }

        public void dfs(int idx, int[][] computers){
            isVisited[idx] = true; // 방문 처리

            for(int i = 0; i < computers[idx].length; i++){
                if(!isVisited[i] && computers[idx][i] == 1){
                    dfs(i, computers);
                }
            }

            return;
        }
    }
}
