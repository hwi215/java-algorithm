package com.stackAndQueue;

import java.util.Stack;

public class StackExem {
    public static void main(String[] args) {
        // 스택생성
        Stack<Integer> stack = new Stack<>();

        // 값 추가
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);

        // 스택 출력
        System.out.println(stack);

        // 맨 위의 값 제거
        // 제거된 값을 top에 저장
        System.out.println(stack);
        int top = stack.pop();


        // top과 스택 출력
        System.out.println("top: " + top + ", stack: " + stack);


        // 스택의 맨 위의 값 출력
        System.out.println(stack.peek());

        // while 반복문을 사용하여 스택의 모든 값 제거, 하나씩 제거될 때마다 스택 출력
        while(!stack.empty()){
            stack.pop();
            System.out.println(stack);
        }

    }
}
