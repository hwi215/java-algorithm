package com.web.programmers.greedy;
import java.util.*;
public class 체육복 {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;

            // 정렬
            Arrays.sort(lost);
            Arrays.sort(reserve);

            // 리스트로 변환
            ArrayList<Integer> arrLost = new ArrayList<>();
            for(int i = 0; i < lost.length; i++){
                arrLost.add(lost[i]);
            }

            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = 0; i < reserve.length; i++){
                arr.add(reserve[i]);
            }

            // 여벌 체육복이 있는 학생이 도난 당한 경우 target 리스트에 저장
            ArrayList<Integer> target = new ArrayList<>();
            for(int i = 0; i < arr.size(); i++){
                for(int j = 0; j < arrLost.size(); j++){
                    if(arrLost.get(j).equals(arr.get(i))){
                        target.add(arr.get(i));
                    }
                }
            }

            int count = n - arrLost.size() + target.size();


            // 체육복 빌려주는 경우
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0; i < arrLost.size(); i++){
                for(int j = 0; j < arr.size(); j++){
                    if(check(arrLost.get(i), arr.get(j)) && !target.contains(arr.get(j)) && !target.contains(arrLost.get(i)) && !tmp.contains(arr.get(j))){

                        count += 1;
                        arr.remove(j);
                    }

                }

            }

            return count;
        }

        // 체육복을 빌려줄 수 있는 경우 - 번호 차이가 1인 경우 true
        public boolean check(int num1, int num2){
            if(Math.abs(num1 - num2) == 1){
                return true;
            }
            return false;

        }
    }
}
