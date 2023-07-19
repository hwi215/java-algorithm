package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TestBit {
    static int[] vote; // 유권자별 투표 순위 리스트 <유권자 번호(0~N-1), 투표 행렬>
    static int[] sum; // 득표 퍼센트 구하기 위해 각 순위별 총 득표 수
    static int N; // 후보의 수
    static List<String> candidateList; // 후보자 담는 리스트
    static List<String> resultList; // 당선된 후보자 리스트

    static int ranking; // 0~(N-1) 순위


    static ArrayList<Integer>[] votes; // 각 순위별로 후보자 우선순위 행렬을 담은 리스트
    static boolean[] rate; // 득표율 50퍼 넘는 지 여부

    static int[] tmp; // 후보자의 득표 수를 담은 배열
    static ArrayList<Integer> outList; // 탈락자 인덱스 담는 리스트


    static void checkRate(int[] arr){ // 득표 비율 계산

        int sum = 0;
        rate = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        for(int i = 0; i < arr.length; i++){

            double d = ((double) arr[i] / (double) sum) * 100.0; // 퍼센트
            if(d >= 50.0){
                rate[i] = true;
            }
        }


    }

    static void outCandidate(){ // 제일 낮은 후보자 탈락 후 점수 넘겨주기

        // 최대값, 최소값
        int min = tmp[0];
        int minIdx = 0;
        int max = 0;
        int maxIdx = 0;

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

        // 탈락자 특표 수
        int outCandiScore = tmp[minIdx];


        if(countMax == 1){ // 한 명일 때만 점수 넘겨주기
            tmp[maxIdx] += outCandiScore;
        }else{ // 여러명 일 때
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

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화
        outList = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        candidateList =new ArrayList<>();
        resultList =new ArrayList<>();

        /* input */
        for(int i = 0; i < N; i++){
            String candidateName = br.readLine(); // 후보자 이름
            candidateList.add(candidateName); // 후보자 추가
        }

        // 초기화
        votes = new ArrayList[N];
        for(int i = 0; i < N; i++){
            votes[i] = new ArrayList<>();
        }

        //vote = new int[N];
        sum = new int[N];


        String line = "";
        String[] input;
        while((line = br.readLine()).length() != 0){ // input 있을 때 까지 입력받기
            // 초기화
            vote = new int[N];

            input = line.split(" ");

            /* input - 우선순위 입력받기 */
            for(int i = 0; i < N; i++) {
                vote[i] = Integer.parseInt(input[i]);
            }

            // 각 순위별 득표수 행렬 생성
            for(int i = 0; i < N; i++){
                votes[i].add(vote[i]);
            }

        }


        ranking = 0;
        tmp = new int[N];
        while(true) {

            if(ranking == N-1){ // 탈락되지 않은 후보가 동률이 될 때
                for(int i = 0; i < tmp[ranking]; i++){
                    if(tmp[i] != 0){
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

            checkRate(tmp); // 득표율 계산

            int countUp50 = 0; // 50퍼 넘는 후보자 수
            for (int i = 0; i < tmp.length; i++) {
                if (rate[i]) {
                    countUp50++; // 50퍼 넘는 후보자 수 갱신
                    resultList.add(candidateList.get(i)); // 50퍼 넘는 후보자 리스트에 담기
                }
            }

            if (countUp50 != 0) { // 50퍼 넘는사람 있는 경우
                for (int i = 0; i < resultList.size(); i++) {
                    System.out.println(resultList.get(i));
                }
                break;

            } else { // 50퍼 넘는사람 없는 경우
                outCandidate(); // 제일 낮은 점수 후보자 탈락  + 점수 옮기기
                ranking++; // 다음 순위로 갱신
            }
        }


    }
}
