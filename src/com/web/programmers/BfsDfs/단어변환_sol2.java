package com.web.programmers.BfsDfs;

import java.util.Arrays;
import java.util.List;

public class 단어변환_sol2 {
    // 백트래킹 + dfs
        static List<String> arrList;
        static boolean[] isVisited;
        static int count;

        public int solution(String begin, String target, String[] words) {
            count = 0;
            int tmp = 0;

            arrList = Arrays.asList(words);

            // words에 target이 존재하지 않는 경우 먼저 처리
            if(!arrList.contains(target)){
                return 0;
            }

            // 단어 변환
            for(int i = 0; i < words.length; i++){
                // 백트래킹
                // begin과 target이 일치할 경우
                if(begin.equals(target)){
                    return count;
                }
                // begin과 target의 단어가 하나만 차이날 경우
                if(check(begin, target)){
                    return count+1;
                }


                // 단어 변환하기
                if(check(begin, words[i])){
                    isVisited =  new boolean[words.length];
                    isVisited[i] = true;
                    dfs(1, arrList.get(i), target);
                }
            }

            return count;
        }

        public void dfs(int index, String s, String t){
            if(s.equals(t)){
                count = index;
                return;
            }

            for(int i = 0; i < arrList.size(); i++){
                if(!isVisited[i] && check(s, arrList.get(i))){ // 방문 안했고, 단어 하나 차이 나는 경우
                    isVisited[i] = true;
                    dfs(index + 1, arrList.get(i), t);
                    isVisited[i] = false;
                }
            }

        }

        // s1과 s2가 하나의 단어만 차이날 경우 true
        public boolean check(String s1, String s2){
            int count = 0;
            for(int j = 0; j < s1.length(); j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    count += 1;
                    if(count > 1){
                        return false;
                    }
                }

            }

            if(count == 1){
                return true;
            }

            return false;

        }


}
