package String;//import java.util.Scanner;
//
//public class String.String_4 {
//    public static String Solution(String str){
//        String result = "";
//        char[] char_arr = str.toCharArray();
//        for(int i = char_arr.length-1; i >=0 ; i--){
//            result += char_arr[i];
//        }
//        return result;
//    }
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int number = in.nextInt();
//        String[] arr = new String[number];
//        for(int i = 0 ; i < number ; i++){
//            String input = in.next();
//            arr[i] = input;
//        }
//        for(int i = 0 ; i < number ; i++){
//            System.out.println(Solution(arr[i]));
//        }
//    }
//}
import java.util.ArrayList;
import java.util.Scanner;

public class String_4 {
    public static ArrayList<String> Solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for(String x : str){
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for(int i = 0 ; i < n ; i++){
            str[i] = in.next();
        }
        for(String x : Solution(n,str)){
            System.out.println(x);
        }
    }
}