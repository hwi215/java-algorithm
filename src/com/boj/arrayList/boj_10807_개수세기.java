package com.boj.arrayList;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class boj_10807_개수세기 {
    public static void main(String[] args) throws IOException {

        // 입력1 - bufferReader => 예외처리 필요!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력2 - Scanner
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int v = Integer.parseInt(sc.nextLine());

        /* 입력1
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int v = Integer.parseInt(br.readLine());
        */

        int count = 0;

        String[] list = s.split(" ");

        for(int i= 0; i < list.length; i++){
            if(Integer.parseInt(list[i]) == v){
                count += 1;
            }
        }

        System.out.println(count);

        /* 입력1
        br.close();
        bw.flush();
        bw.close();

         */

    }
}
