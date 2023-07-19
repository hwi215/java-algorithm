package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.DoubleStream;

public class TestBit {
    static int[] vote;
    static int[] sum;
    static String[] input;
    static int count;
    static int N;
    static List<String> candidateList;

    static int max;
    static int maxIdx;
    static List<Integer> maxList;

    static int min;
    static int minIdx;

    static ArrayList<Integer>[] votes;
    static boolean[] rate;

    static int[] tmp;
    static ArrayList<Integer> outList; // 탈락자 번호 리스트

    static int ranking;

    static void rank(){
        /**
         * 처음, 1순위만 집계 - 50%이상 득표시 바로 선출 break
         * 50%이상 득표 없으면?
         * 가장 적은 표 받은 사람 탈락
         * 탈락된 후보를 1순위로 뽑은 표 집계 -> 아직 탈락되지 않은 후보 중 가장 높은 선호도르 ㄹ얻은 후보가 그 표를 얻음
         *
         * 이런식으로,
         * 가장 약한 후보를 탈락시키면서
         * 다음 순위의 탈락하지 않는 후보에게 표를 주는과정 반복
         * (50퍼 이상 얻은 후보가 나오거나, 탈락되지 않은 후보가 동률이 될 때까지 반복)
         *
         */
    }

    static void checkRate(int[] arr){ // 득표 비율 계산

        int sum = 0;
        rate = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        for(int i = 0; i < arr.length; i++){

            double d = ((double) arr[i] / (double) sum) * 100.0; // 퍼센트
            System.out.println("sum: " + sum + ", " + arr[i]);
            System.out.println("d: " + d);
            if(d >= 50.0){
                rate[i] = true;
            }
        }

        System.out.println("득표비율: " + Arrays.toString(rate));

    }

    static void outCandidate(ArrayList<Integer> arr){ // 제일 낮은 후보자 탈락 후 점수 넘겨주기

        System.out.println("탈락자 내보내기~~~~~~~~~~~~~~~");
        min = tmp[0];
        minIdx = 0;
        max = 0;
        maxIdx = 0;

        int countMax = 0; // 가장 높은 선호도를 가진 인원 수
        for(int i = 0; i < tmp.length; i++){
            if(min > tmp[i]){  // 최소값 찾기
                min = tmp[i];
                minIdx = i;
            }
            if(max < tmp[i]){ // 최대값 찾기
                max = tmp[i];
                maxIdx = i;
                countMax++;
            }

        }
        System.out.println("maxIdx: " + maxIdx + ", minIdx: " + minIdx);

        int outCandiScore = 0;
        outCandiScore = tmp[minIdx];


        if(countMax == 1){ // 한 명일 때만 점수 넘겨주기
            System.out.println("한 명일때");
            tmp[maxIdx] += outCandiScore;
        }else{
            System.out.println("여러명 일때");
            for(int i = 0; i < votes[ranking].size(); i++){
                if(votes[ranking].get(i) == (minIdx+1)){
                    if(ranking+1 <= N-1){
                        tmp[votes[ranking+1].get(i)] += outCandiScore; // 선호도 더 높은 후보자에게 점수 넘기기
                    }

                }
            }
        }

        tmp[minIdx] = 0; // 탈락자 투표수 초기화
        outList.add(minIdx); // 탈락자 리스트 갱신

        /*
        int tmp = arr.get(maxIdx);
        tmp += outCandiScore;

        int[] arr2 = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            arr2[i] = arr.get(i);
        }

        arr2[maxIdx] += outCandiScore; // 값 갱신
        arr2[minIdx] = 0; // 탈락처리

        arr.clear(); // 초기화


        for(int i = 0; i < arr.size(); i++){
            arr.add(arr2[i]);
        }

        return arr;

         */
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        outList = new ArrayList<>(); // 탈락자 인덱스 담는 리스트
        N = Integer.parseInt(br.readLine()); // 후보의 수
        candidateList =new ArrayList<>(); // 후보자 담는 리스트
        List<String> resultList =new ArrayList<>(); // 당선된 후보자 리스트

        for(int i = 0; i < N; i++){
            String candidateName = br.readLine();
            candidateList.add(candidateName); // 후보자 추가
        }

        System.out.println(candidateList.toString());

        String line = "";

        // 배열안에 리스트 넣기
        votes = new ArrayList[N]; // 유권자별 투표 순위 리스트 <유권자 번호(0~N-1), 투표 행렬>

        // 초기화
        for(int i = 0; i < N; i++){
            votes[i] = new ArrayList<>();
        }


        vote = new int[N]; // N, 초기화
        sum = new int[N];
        int c = 0;
        System.out.println();


        while((line = br.readLine()).length() != 0){
            vote = new int[N]; // N, 초기화

            input = line.split(" ");

            for(int i = 0; i < N; i++) { // 입력받은 우선순위
                vote[i] = Integer.parseInt(input[i]);
            }


            for(int i = 0; i < N; i++){
                votes[i].add(vote[i]);
            }

            for(int i = 0; i < N; i++){
                System.out.println(votes[i].toString());
            }

            System.out.println("===============");


        }
        System.out.println("여기서부터");


        int votersNum = 0;
        votersNum = votes[0].size();

        ranking = 0;
        tmp = new int[N];
        while(true) {
            System.out.println("tmp: " + Arrays.toString(tmp) + "ranking: " + ranking);

            if(ranking == N-1){ // 탈락되지 않은 후보가 동률이 될 때
                for(int i = 0; i < tmp[ranking]; i++){
                    if(tmp[i] != 0){
                        System.out.println("--------마지막-----------");
                        System.out.println(candidateList.get(i));
                    }
                }
                break;
            }

            // 0~(N-1) 순위만
            for (int i = 0; i < votes[ranking].size(); i++) {
                if(!outList.contains(votes[ranking].get(i) - 1)) { // 탈락자에 포함되지 않은 사람들만 득표수 갱신
                    tmp[votes[ranking].get(i) - 1]++;
                }
            }
            System.out.println("tmp갱신!!: " + Arrays.toString(tmp) + "ranking: " + ranking);

            checkRate(tmp); // 득표율 계산

            int countUp50 = 0; // 50퍼 넘는 후보자 수
            for (int i = 0; i < tmp.length; i++) {
                if (rate[i]) {
                    countUp50++;
                    resultList.add(candidateList.get(i));
                }
            }

            if (countUp50 != 0) {
                System.out.println("50퍼 넘는사람 있음 !!!" + countUp50);
                for (int i = 0; i < resultList.size(); i++) {
                    System.out.println(resultList.get(i));
                }
                System.out.println("--------50퍼 넘음-----------");
                break;

            } else { // 50퍼 넘는사람 없는 경우
                System.out.println("50퍼 넘는 경우 없음!!");
                outCandidate(votes[ranking]); // 제일 낮은 점수 후보자 탈락  + 점수 옮기기
                ranking++;
            }
        }

        System.out.println("end");


    }
}

/**
 *
 3
 John Doe
 Jane Smith
 Jane Austen
 1 2 3
 2 1 3
 2 3 1
 1 2 3
 3 1 2
 */