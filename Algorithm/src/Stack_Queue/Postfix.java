package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static int solution(String str){
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int a = 0;
        int b = 0;
        for(char c: str.toCharArray()){
            if(c!='+'&&c!='-'&&c!='*'&&c!='/'){
                stack.push(Character.getNumericValue(c));
            } else{
                a = stack.pop();
                b = stack.pop();
                switch (c){
                    case '+':
                        stack.push(b+a);
                        break;
                    case '-':
                        stack.push(b-a);
                        break;
                    case '*':
                        stack.push(b*a);
                        break;
                    case '/':
                        stack.push(b/a);
                        break;
                }
            }
        }
        answer = stack.pop();
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}
