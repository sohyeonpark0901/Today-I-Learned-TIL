//package HashMap;
//
//import java.util.*;
//
//public class ClassPresident {
//    public static String solution(int n, String[] arr){
//        String answer;
//        HashMap<String,Integer> map = new HashMap<String,Integer>();
//        map.put("A",0);
//        map.put("B",0);
//        map.put("C",0);
//        map.put("D",0);
//        map.put("E",0);
//        for(String s : arr){
//            map.put(s, map.get(s)+1);
//        }
//        // Comparator 정의
//        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
//                return e1.getValue().compareTo(e2.getValue());
//            }
//        };
//        // Max Value의 key, value
//        Map.Entry<String, Integer> maxEntry = Collections.max(map.entrySet(), comparator);
//        answer = maxEntry.getKey();
//        return  answer;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String s = in.nextLine();
//        String[] arr = s.split("");
//        System.out.println(solution(n,arr));
//    }
//}

// 또다른 풀이
package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class ClassPresident {
    public static char solution(int n, String s){
        char answer =' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
            /*
            * map.getOrDefault : 키값에 해당하는 value를 가져오되, 없으면 Default값으로 넣도록한다.
            * */
        }
        int max = Integer.MIN_VALUE;
        for(char key: map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
    }
}
/*
* Map에 대한 추가 설명
* map.containsKey() : 키에 대한 존재 여부
* map.size() : 키 갯수 반환
* map.remove() : 특정 키 삭제
* */