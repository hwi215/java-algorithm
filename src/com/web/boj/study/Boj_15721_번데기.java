package com.web.boj.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15721_번데기 {

    static int n;
    static int bb; // 뻔
    static int dd; // 데기

    static void print(){
        int count = bb+ dd- 1;
        System.out.println(count%n);
        return;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, t, type
        n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        int type = Integer.parseInt(br.readLine());

        int round = 2;

        while (true) {

            // 뻔 데기 뻔 데기 뻔*n 데기*n
            // 1) 뻔 데기 뻔 데기
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) { // 뻔
                    bb++;
                    if (bb == t && type == 0) {
                        print();
                        return;
                    }
                } else { // 데기
                    dd++;
                    if (dd == t && type == 1) {
                        print();
                        return;
                    }
                }
            }

            // 2) 뻔*n 데기*n

        for (int i = 0; i < round; i++) { // 뻔*n
                bb++;
                if (bb == t && type == 0) {
                    print();
                    return;
                }

            }

            for (int i = 0; i < round; i++) { // 데기*n
                dd++;
                if (dd == t && type == 1) {
                    print();
                    return;
                }

            }

            round++;
        }

    }

}
