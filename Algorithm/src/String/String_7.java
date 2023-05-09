package String;//import java.util.Scanner;
//import java.util.Stack;
//
//public class String.String_7 {
//    public static String Solution(String str){
//        String result = "";
//        str = str.toLowerCase();
//        String str_reverse = "";
//        Stack<Character> stack = new Stack<>();
//        for(char c : str.toCharArray()){
//            stack.push(c);
//        }
//        while(!stack.isEmpty()){
//            char c = stack.pop();
//            str_reverse += c;
//        }
//
//        if(!str.equals(str_reverse)){
//            result = "NO";
//        }else {
//            result = "YES";
//        }
//        return result;
//    }
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String input = in.next();
//        System.out.println(Solution(input));
//    }
//}

//또다른 풀이 1
//import java.util.Scanner;
//
//public class String.String_7 {
//    public static String Solution(String str){
//        String answer = "YES";
//        str = str.toUpperCase();
//        int len = str.length();
//        for(int i = 0 ; i < len/2 ; i++){
//            if(str.charAt(i) != str.charAt(len - i - 1)) return "NO";
//        }
//        return answer;
//    }
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String input = in.next();
//        System.out.println(Solution(input));
//    }
//}

//또다른 풀이 2
import java.util.Scanner;

public class String_7 {
    public static String Solution(String str){
        String answer = "YES";
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equalsIgnoreCase(tmp)) answer = "YES";
        /* equalsIgnoreCase : 대소문자 구분 안함 */
        return answer;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(Solution(input));
    }
}