package com.boj.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_11725_트리의부모찾기 {

    static int N;
    static boolean[] isVisted;
    static ArrayList<Integer>[] tree;
    static int[] parent; // 부모 찾기

    static void searchParent(int v){

        isVisted[v] = true; // 방문체크

        for(int target : tree[v]){
            if(!isVisted[target]){
                parent[target] = v; // 부모 찾음
                searchParent(target);
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 트리 생성
        tree = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            tree[i] = new ArrayList<>(); // 트리의 각 정점에 리스트 만들어주기
        }

        // 트리 초기화
        for(int i = 0; i < N-1; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // 양방향 설정
            tree[a].add(b);
            tree[b].add(a);

        }

        // 초기화
        isVisted = new boolean[N+1];
        parent = new int[N+1];


        searchParent(1); // 루트노드부터 탐색 시작

        for(int i = 2; i < parent.length; i++){ // 노드 2부터 부모 출력
            System.out.println(parent[i]);
        }

    }
}
