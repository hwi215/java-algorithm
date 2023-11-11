package com.web.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Boj_1991_트리순회 {
    static Map<String, ArrayList<String>> tree;

    static void pre(String target){ // 전위 순회(루트 - 왼쪽 자식 - 오른쪽 자식)
        if(target != "."){
            for(Map.Entry<String, ArrayList<String>> node: tree.entrySet()){
                if(node.getKey().equals(target)){
                    System.out.print(node.getKey()); // 부모 노드 출력
                    pre(node.getValue().get(0)); // left 노드 전위 순회
                    pre(node.getValue().get(1)); // right 노드 전위 순회
                }
            }
        }
    }

    static void in(String target){ // 중위 순회(왼쪽자식 - 루트 - 오른쪽자식)
        if(target != "."){
            for(Map.Entry<String, ArrayList<String>> node: tree.entrySet()){
                if(node.getKey().equals(target)){
                    in(node.getValue().get(0)); // left 노드 중위 순회
                    System.out.print(node.getKey()); // 부모 노드 출력
                    in(node.getValue().get(1)); // right 노드 중위 순위
                }
            }
        }
    }

    static void post(String target){ // 후위 순회(왼쪽 자식 - 오른쪽 자식 - 루트)
        if(target != "."){
            for(Map.Entry<String, ArrayList<String>> node: tree.entrySet()){
                if(node.getKey().equals(target)){
                    post(node.getValue().get(0)); // left 노드 후위 순회
                    post(node.getValue().get(1)); // right 노드 후위 순위
                    System.out.print(node.getKey()); // 부모 노드 출력
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 초기화
        tree = new HashMap<>();

        // 트리 생성
        for(int i = 0; i < N; i++){
            String[] input = br.readLine().split(" ");
            String root = input[0];
            String left = input[1];
            String right = input[2];

            // tree[root] = [left, right]
            ArrayList<String> li = new ArrayList<>();
            li.add(left);
            li.add(right);
            tree.put(root, li); // 트리 설정

        }

        // 항상 루트노드는 A
        pre("A");
        System.out.println();
        in("A");
        System.out.println();
        post("A");

    }
}
