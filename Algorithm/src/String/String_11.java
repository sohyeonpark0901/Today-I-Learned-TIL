package String;

import java.util.Scanner;

public class String_11 {
    public static String Solution(String str){
        String answer = "";
        char[] str_arr = str.toCharArray();
        char point = str_arr[0];
        int count = 1;
        for(int i =1; i< str_arr.length; i++){
            if(str_arr[i]==point){
                count++;
                if(i== str_arr.length-1){ // 또는 마지막 str에 빈문자 처음에 추가해서 비교하기
                    answer+=point;
                    answer+=Integer.toString(count);
                }
            }else{
                answer+=point;
                if(count!=1){
                    answer+=Integer.toString(count);
                }
                count=1;
                point=str_arr[i];
                if(i== str_arr.length-1){
                    answer+=str_arr[i];
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(Solution(str));
    }
}
