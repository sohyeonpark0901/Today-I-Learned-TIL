package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisCharacterRemove {
    public static String solution(String str){
        Object[] result;
        Stack<Character> stack = new Stack<Character>();
        String answer = "";
        for(char c : str.toCharArray()){
            stack.push(c);
            if(c==')'){
                while(stack.peek()!='('){
                    stack.pop();
                }
                stack.pop();
            }
        }
        result = stack.toArray();
        for(Object s: result){
            answer += s;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}
