package com.web.programmers.BfsDfs;

public class 단어변환 {
    class Solution {
        public int solution(String begin, String target, String[] words) {
            int count = 0;
            int tmp = 0;

            // words에 target이 존재하지 않는 경우 먼저 처리
            for(int i = 0; i < words.length; i++){
                if(!target.equals(words[i])){
                    tmp += 1;
                }
            }
            if(tmp == words.length){
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
                    count += 1;
                    begin = words[i];
                }
            }

            return count;
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
}
