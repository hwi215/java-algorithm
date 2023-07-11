package com.stackAndQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 선언:
 *         Queue queue = new LinkedList<>();
 *         Queue queue1 = new ArrayDeque<>();
 *         Queue queue2 = new LinkedList<>();
 *
 * 추가: offer(), add()
 * 제거: remove(), poll()
 * 맨 앞의 데이터 반환: peek()
 * 비어있나?: isEmpty()
 * 큐에 저장된 값을 문자열로 반환: toString()
 * 큐 비우기: clear()
 */
public class QueueEx {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        Queue<String> queue1 = new ArrayDeque<>();
        Queue<Character> queue2 = new LinkedList<>();

        // 추가
        queue.offer(1);
        queue.add(2);
        queue.offer(3);
        queue.add(4);

        System.out.println(queue);

        // 삭제
        int target = queue.poll();
        System.out.println(queue);

        // 맨 앞 데이터 반환
        int target2 = queue.peek();
        System.out.println(target2);

        // 비어있나?
        System.out.println(queue.isEmpty());

        // 출력
        System.out.println(queue.toString()); // [2, 3, 4]

        // 큐 비우기
        queue.clear();

        System.out.println(queue);


    }
}
