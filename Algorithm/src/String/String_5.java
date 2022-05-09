package String;//import java.util.Scanner;
//
//public class String.String_5 {
//    public static String Solution(String str){
//        String result = "";
//        char[] tmp_arr = str.toCharArray();
//        for(int i =0 ; i < tmp_arr.length; i++){
//            if(Character.isAlphabetic(tmp_arr[i]) && i < tmp_arr.length/2){
//                char c = tmp_arr[i];
//                tmp_arr[i] = tmp_arr[Math.abs(i-(tmp_arr.length-1))];
//                tmp_arr[Math.abs(i-(tmp_arr.length-1))] = c;
//            }
//        }
//        for(char c : tmp_arr){
//            result += c;
//        }
//        return result;
//    }
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String input = in.next();
//        System.out.println(Solution(input));
//    }
//}

// 또다른 풀이
import java.util.Scanner;

public class String_5 {
    public static String Solution(String str){
        String answer;
        char[] s = str.toCharArray();
        int lt = 0, rt = s.length -1;
        while(lt<rt){
            if(!Character.isAlphabetic(s[lt])) lt++;
            else if(!Character.isAlphabetic(s[rt])) rt--;
            else{
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(Solution(input));
    }
}
