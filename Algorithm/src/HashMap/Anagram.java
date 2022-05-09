//package HashMap;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Anagram {
//    public static String solution(String str1, String str2){
//        String answer = "YES";
//        String[] arr1 = str1.split("");
//        String[] arr2 = str2.split("");
//        Map<String,Integer> hash1 = new HashMap<String,Integer>();
//        Map<String,Integer> hash2 = new HashMap<String,Integer>();
//        for(String s: arr1){
//            if(hash1.containsKey(s)) hash1.put(s, hash1.get(s)+1 );
//            else hash1.put(s,1);
//        }
//        for(String s: arr2){
//            if(hash2.containsKey(s)) hash2.put(s, hash2.get(s)+1 );
//            else hash2.put(s,1);
//        }
//        for(String strKey:hash1.keySet()){
//            if(!hash2.containsKey(strKey)){
//                answer = "NO";
//            } else{
//                if(hash1.get(strKey)!=hash2.get(strKey)){
//                    answer="NO";
//                }
//            }
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str1 = in.nextLine();
//        String str2 = in.nextLine();
//        System.out.println(solution(str1, str2));
//    }
//}

// 또다른 풀이
package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static String solution(String s1, String s2){
        String answer = "YES";
        HashMap<Character,Integer> map = new HashMap<>();
        for(char x: s1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for(char x:s2.toCharArray()){
            if(!map.containsKey(x)||map.get(x)==0) return "NO";
            map.put(x, map.get(x)-1);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(solution(str1, str2));
    }
}
