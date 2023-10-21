package com.web.programmers.BfsDfs;
import java.util.*;

public class 여행경로 {
    // dfs
    class Solution {
        static boolean[] isVisited;
        static ArrayList<String> answers;
        public String[] solution(String[][] tickets) {
            answers = new ArrayList<>();
            isVisited = new boolean[tickets.length];
            dfs(0, tickets, "ICN", "ICN");

            // 오름차순 정렬
            Collections.sort(answers);
            String[] answer = answers.get(0).split(" ");
            return answer;
        }

        public void dfs(int count, String[][] tickets, String start, String answer){
            if(count == tickets.length){
                answers.add(answer); // 경로 추가
                return;
            }
            for(int i = 0; i < tickets.length; i++){
                if(tickets[i][0].equals(start) && !isVisited[i]){
                    isVisited[i] = true;
                    dfs(count + 1, tickets, tickets[i][1], answer + " " + tickets[i][1]);
                    isVisited[i] = false;
                }
            }

        }
    }
}
