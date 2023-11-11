package com.sorting;

import java.util.*;

public class Sort {
    public static void main(String[] args) {
        Integer[] intArr = {8,7,6,5,4};
        Arrays.sort(intArr); // 오름차순 정렬

        Arrays.sort(intArr, Collections.reverseOrder()); // 내림차순 정렬
        // Collections.reverseOrder()
        int[][] routes = new int[5][5];

        // 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] route1, int[] route2){
                return route1[1] - route2[1];
            }

        });
        String[] str = new String[5];
        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }

        });

        Arrays.sort(str, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }

        });

        HashMap<String, Integer> map = new HashMap<>();

        for(String name: map.keySet()){
            if(map.get(name) == null){
                map.put(name, map.get(name)+1);
            }
        }

        //해쉬정렬 - get, put
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        String answer = "";
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            if(entry.getValue() == 0){
                answer = entry.getKey();
                break;
            }
        }

        //
        HashMap<String, Integer> map2 = new HashMap<>();

        Iterator<Map.Entry<String, Integer>> iter2 = map2.entrySet().iterator();

        while(iter2.hasNext()){
            Map.Entry<String, Integer> entry2 = iter.next();

        }
        return;

    }
}
