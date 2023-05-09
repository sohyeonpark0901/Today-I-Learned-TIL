//package Stack_Queue;
//
//import java.util.Scanner;
//import java.util.Stack;
//
//public class CorrectParentheses {
//    public static String solution(String str){
//        String answer = "YES";
//        Stack<Character> stack = new Stack<>();
//        for(char c: str.toCharArray()) stack.push(c);
//        for(int i= stack.size()-1; i>=0;i--){
//            if(stack.size()==0) break;
//            else if(stack.peek() == ')') {
//                stack.pop();
//                stack.pop();
//            }
//        }
//        if(stack.size()!=0) answer="NO";
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
//        System.out.println(solution(input));
//    }
//}
// 위의 풀이는 오답이라 나옴
package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class CorrectParentheses {
    public static String solution(String str){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c=='(') stack.push(c);
            else if(stack.size()!=0 && c==')') stack.pop();
            else answer="NO";
        }
        if(stack.size()!=0) answer="NO";
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(solution(input));
    }
}
