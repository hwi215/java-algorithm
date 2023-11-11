package com.web.boj.arrayList;

import java.io.*;

public class Boj_10807_개수세기 {
    public static void main(String[] args) throws IOException {

        // 입력1 - bufferReader => 예외처리 필요! - 스캐너보다 속도가 훨씬 빠름!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력2 - Scanner
        //Scanner sc = new Scanner(System.in);



        // 입력1
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int v = Integer.parseInt(br.readLine());


        /* 입력2
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int v = Integer.parseInt(sc.nextLine());
         */

        int count = 0;

        String[] list = s.split(" ");

        for(int i= 0; i < list.length; i++){
            if(Integer.parseInt(list[i]) == v){
                count += 1;
            }
        }

        System.out.println(count);

        // 입력1
        br.close();
        bw.flush();
        bw.close();


    }
}
