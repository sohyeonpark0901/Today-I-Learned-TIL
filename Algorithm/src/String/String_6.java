package String;//import java.util.Arrays;
//import java.util.LinkedHashSet;
//import java.util.Scanner;
//
//public class String.String_6 {
//    public static String Solution(String str){
//        String result = "";
//        String[] arr = str.split("");
//        LinkedHashSet<String> linkedHashSet =
//                new LinkedHashSet<>(Arrays.asList(arr));
//
//        String[] resultArr = linkedHashSet.toArray(new String[0]);
//        /*
//        * HashSet ? set 인터페이스의 구현체이다
//        * set은 중복해서 객체를 저장할 수 없고 하나의 null값만 저장할 수 있다.
//        * 저장 순서가 보장 되지 않기에 저장 순서가 보장 되는 LinkedHashSet을 사용한다.
//        * */
//        for(String s: resultArr){
//            result += s;
//        }
//        return result;
//    }
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        String input = in.next();
//        System.out.println(Solution(input));
//    }
//}

//또다른 풀이
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class String_6 {
    public static String Solution(String str){
        String answer = "";
        for(int i = 0 ; i< str.length();i++){
            if(str.indexOf(str.charAt(i))==i) answer+=str.charAt(i);
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.next();
        System.out.println(Solution(input));
    }
}