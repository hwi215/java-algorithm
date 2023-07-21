package com.boj.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1717_집합의표현 {

    static int[] parent;

    static void union(int a, int b){
        // 부모 찾기
        a = find(a);
        b = find(b);

        if(a != b){ // 부모가 다른 경우
            if(a < b){
                parent[b] =a;
            }else{
                parent[a] = b;
            }

        }

    }
    static int find(int num){
        if(parent[num] == num){ // 루트 노드인 경우
            return num;
        }
        return parent[num] = find(parent[num]); // 부모찾아서 리턴 -> 여기서 시간초과 문제 해결함

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        //StringBuilder sb = new StringBuilder();

        int n  = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());


        // 초기화
        parent = new int[n+1];
        for(int j = 0; j <= n; j++){
            parent[j] = j;
        }

        for(int i = 0; i < m; i++){
            String input2 = br.readLine();

            StringTokenizer st2 = new StringTokenizer(input2);
            int state  = Integer.parseInt(st2.nextToken());
            int a  = Integer.parseInt(st2.nextToken());
            int b  = Integer.parseInt(st2.nextToken());


            if(state == 0){ // 합집합

                union(a, b);

            }else if (state == 1){

                if(find(a) == find(b)){ // 부모 같은 경우
                    //sb.append("YES").append("\n");
                    System.out.println("YES");
                }else{
                    //sb.append("NO").append("\n");
                    System.out.println("NO");
                }
            }

        }

        //System.out.println(sb);

    }
}
