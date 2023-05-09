package String;

import java.util.Scanner;

public class String_2 {
    public static String Solution(String str){
        String result = "";
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c)){
                result += Character.toLowerCase(c);
            }
            else{
                result += Character.toUpperCase(c);
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.print(Solution(input));
    }
}
