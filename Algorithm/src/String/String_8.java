package String;

import java.util.Scanner;

public class String_8 {
    public static String Solution(String s){
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]","");
        System.out.println(s);
        /* "[^A-Z]" : A-Z가 아니면 */
        String tmp = new StringBuilder(s).reverse().toString();
        if(s.equals(tmp)) answer = "YES";
        return answer;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(Solution(input));
    }
}