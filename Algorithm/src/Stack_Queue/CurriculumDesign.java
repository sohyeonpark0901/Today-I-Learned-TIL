//package Stack_Queue;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class CurriculumDesign {
//    public static String solution(String str1, String str2){
//        String answer = "YES";
//        Queue<Character> queue1 = new LinkedList<>();
//        for(char c : str1.toCharArray()) queue1.add(c);
//        for(char c : str2.toCharArray()){
//            if(!queue1.isEmpty() && c == queue1.peek()) queue1.remove();
//        }
//        if(!queue1.isEmpty()) answer = "NO";
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String input1 = in.nextLine();
//        String input2 = in.nextLine();
//        System.out.println(solution(input1,input2));
//    }
//}

// 또다른 풀이
package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CurriculumDesign {
    public static String solution(String need, String plan){
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x: need.toCharArray()) Q.offer(x);
        for(char x: plan.toCharArray()) {
            if(Q.contains(x)){
                if(x!=Q.poll()) return "NO";
            }
        }
        if(!Q.isEmpty()) return "NO";
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();
        System.out.println(solution(input1,input2));
    }
}
