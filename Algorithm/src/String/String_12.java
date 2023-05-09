package String;/*
import java.util.Scanner;

public class String.String_12 {
    public static String solution(int count, String str){
        String answer = "";
        char[] str_arr = str.toCharArray();
        String tmp = "";
        int x;
        for(int i = 0; i < 7*count ; i++){
            if(str_arr[i]=='#'){
                tmp +="1";
            }else {
                tmp +="0";
            }
            if((i+1)%7==0){
                x = Integer.parseInt(tmp,2);
                answer += (char)x;
               tmp = "";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        String input2 = in.next();
        System.out.println(solution(input1,input2));
    }
}
*/
// 또다른 풀이
import java.util.Scanner;

public class String_12 {
    public static String solution(int n, String s){
        String answer = "";
        for(int i = 0; i<n; i++){
            String tmp = s.substring(0,7).replace("#","1").replace("*","0");
            /**
             * 0~6까지 자르고
             * #은 1으로 바꾸고
             * *은 0으로 변환
             * */
            int num = Integer.parseInt(tmp, 2);
            answer+=(char)num;
            s=s.substring(7); //7~끝까지로 변환

        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input1 = in.nextInt();
        String input2 = in.next();
        System.out.println(solution(input1,input2));
    }
}
