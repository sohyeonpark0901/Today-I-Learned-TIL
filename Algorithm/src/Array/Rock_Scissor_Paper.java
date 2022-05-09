package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rock_Scissor_Paper {
    public static List<String> solution(int count, String a, String b){
        List<String> answer = new ArrayList<String>();
        String[] arrA = a.split(" ");
        String[] arrB = b.split(" ");
        int result = 0;
        for(int i = 0 ; i < count; i++){
            result= win(Integer.parseInt(arrA[i]), Integer.parseInt(arrB[i]));
            switch (result){
                case 1:
                    answer.add("A");
                    break;
                case 2:
                    answer.add("B");
                    break;
                default:
                    answer.add("D");
                    break;
            }
        }
        return answer;
    }
    public static int win(int a, int b){
        int result = 0; // 1 이김 2 짐 3 비김
        switch (a){
            case 1:
                if(b==1){
                    result = 3;
                } else if(b==2){
                    result = 2;
                } else {
                    result = 1;
                }
                break;
            case 2:
                if(b==1){
                    result = 1;
                } else if(b==2){
                    result = 3;
                } else {
                    result = 2;
                }
                break;
            case 3:
                if(b==1){
                    result = 2;
                } else if(b==2){
                    result = 1;
                } else {
                    result = 3;
                }
                break;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String A = in. nextLine();
        String B = in.nextLine();
        List<String> result = solution(count, A, B);
        for(int i = 0 ; i< result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
