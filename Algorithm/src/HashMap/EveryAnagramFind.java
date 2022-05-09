//package HashMap;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//
//public class EveryAnagramFind {
//    public static int solution(String s1, String s2){
//        int answer = 0;
//        boolean flag = false;
//        char[] arr1 = s1.toCharArray();
//        HashMap<Character,Integer> s2_hm = new HashMap<Character, Integer>();
//        HashMap<Character,Integer> tmp = new HashMap<Character, Integer>();
//        for(char c: s2.toCharArray()){
//            s2_hm.put(c,s2_hm.getOrDefault(c,0)+1);
//        }
//        for(int i=0;i<s2.length()-1;i++){
//            tmp.put(arr1[i],tmp.getOrDefault(arr1[i],0)+1);
//        }
//        int lt = 0;
//        for(int rt=s2.length()-1;rt<s1.length();rt++){
//            tmp.put(arr1[rt],tmp.getOrDefault(arr1[rt],0)+1);
//            if(tmp.equals(s2_hm)) answer++;
//            tmp.put(arr1[lt],tmp.get(arr1[lt])-1);
//            if(tmp.get(arr1[lt]) ==0) tmp.remove(arr1[lt]);
//            lt++;
//        }
//
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str1 = in.nextLine();
//        String str2 = in.nextLine();
//        System.out.println(solution(str1,str2));
//    }
//}
// 또다른 풀이
package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EveryAnagramFind {
    public static int solution(String a, String b){
        int answer = 0;
        HashMap<Character,Integer> am = new HashMap<Character, Integer>();
        HashMap<Character,Integer> bm = new HashMap<Character, Integer>();
        for(char x: b.toCharArray()) bm.put(x,bm.getOrDefault(x,0)+1);
        int L = b.length()-1;
        for(int i=0;i<L;i++) am.put(a.charAt(i),am.getOrDefault(a.charAt(i),0)+1);
        int lt = 0;
        for(int rt=L;rt<a.length();rt++){
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt),0)+1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt),am.get(a.charAt(lt))-1);
            if(am.get(a.charAt(lt))==0) am.remove(a.charAt(lt));
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        System.out.println(solution(str1,str2));
    }
}
