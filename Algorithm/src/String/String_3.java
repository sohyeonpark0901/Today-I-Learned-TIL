package String;//import java.util.Scanner;
//
//public class String.String_3 {
//
//    public static String Solution(String str){
//        String[] arr = str.split(" ");
//        int max = 0;
//        String result = null;
//        for(String s : arr){
//            int len = s.length();
//            if(len > max){
//                max = len;
//                result = s;
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String input = in.nextLine();
//        System.out.println(Solution(input));
//    }
//}
// 또다른 풀이
import java.util.Scanner;

public class String_3 {

    public static String Solution(String str){
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while((pos=str.indexOf(' '))!=-1){
            String tmp = str.substring(0,pos);
            int len = tmp.length();
            if(len > m){
                m=len;
                answer=tmp;
            }
            str=str.substring(pos+1);
        }
        if(str.length()>m) answer = str;
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(Solution(str));
    }
}