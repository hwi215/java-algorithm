package com.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExam {
    public static void main(String[] args) {
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 값 추가
        queue.offer(100);
        queue.offer(200);
        queue.offer(300);
        queue.offer(400);
        queue.offer(500);

        // 맨 앞 값 제거 = front, 출력
        int front = queue.peek();
        System.out.println("front: " + front + ", Queue: " + queue);

        System.out.println("peek: " + queue.peek());

        // 큐 비우기
        while(!queue.isEmpty()){
            queue.poll();
            System.out.println(queue);
        }
    }
}
