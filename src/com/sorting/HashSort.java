package com.sorting;

import java.util.*;

/**
 * 해시함수 정렬
 */
public class HashSort {

    static HashMap<String, Integer> map;
    public static void main(String[] args) {
        map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);

        for(String name: map.keySet()){
            System.out.print(name);
            System.out.println(map.get(name));
        }

        System.out.println("========value값 증가=======");
        for(String name: map.keySet()){
            map.put(name, map.get(name)+1);
            System.out.print(name);
            System.out.println(map.get(name));
        }


        /**
         * 해시정렬
         */
        Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();

        System.out.println("=========key, value 출력========");
        while(iter.hasNext()){
            Map.Entry<String, Integer> entry = iter.next();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        System.out.println("=========key값을 기준으로 정렬======");

        System.out.println("오름차순 정렬");
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        print(keySet);

        System.out.println("내림차순 정렬");
        Collections.reverse(keySet);
        print(keySet);


        System.out.println("=========vlaue값을 기준으로 정렬======");

        List<String> keySet2 = new ArrayList<>(map.keySet());

        System.out.println("오름차순 정렬");
        keySet2.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return map.get(o1).compareTo(map.get(o2));
            }
        });
        print(keySet2);

        System.out.println("오름차순 정렬");
        keySet2.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        print(keySet2);

        System.out.println("[람다식] 오름차순 정렬");
        keySet.sort((o1, o2) -> map.get(o1).compareTo(map.get(o2)));
        print(keySet);

        System.out.println("[람다식] 내림차순 정렬");
        keySet.sort((s1, s2) -> map.get(s2).compareTo(map.get(s1)));
        print(keySet);


    }

    public static void print(List<String> keySet){
        for(String key : keySet){
            System.out.println("key: " + key + ", value: " + map.get(key));
        }
    }

}
