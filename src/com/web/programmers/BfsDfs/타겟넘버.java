package com.web.programmers.BfsDfs;

/**
 * [문제]
 * 사용할 수 있는 숫자가 담긴 배열 numbers,
 * 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
 *
 * +4+1-2+1 = 4
 * +4-1+2-1 = 4
 */
public class 타겟넘버 {
        static int count = 0;
        public int solution(int[] numbers, int target) {

            dfs(0, numbers, 0, target);
            return count;
        }

        public void dfs(int idx, int[] numbers, int answer, int target){
            if(idx == numbers.length){
                if(answer == target){
                    count += 1;
                }
                return;
            }
            dfs(idx + 1, numbers, answer + numbers[idx], target);
            dfs(idx + 1, numbers, answer - numbers[idx], target);
        }
}
