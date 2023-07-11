package com.stack;

import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();


        // push 메소드 ---> O(1)
        st.push(1);

        System.out.println(st);

        st.add(100);

        // add(인덱스, 값) ---> O(N)
        st.add(1, 11);

        // pop 메소드 --- O(1)
        int popValue = st.pop ();
        System.out.println(st + ", " + popValue);

        // remove 메소드
        st.remove(2);

        // peek 메소드 = 가장 위에 있는 값을 반환 = pop 했을 때 삭제될 값
        System.out.println(st.peek());

        // isEmpty 메소드
        System.out.println(st.isEmpty());

        // clear 메소드 = 스택 초기화
        st.clear();
        System.out.println(st.isEmpty());

    }
}
