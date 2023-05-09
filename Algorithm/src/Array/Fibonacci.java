package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {

    public static List<Integer> solution(int num){
        List<Integer> answer = new ArrayList<Integer>();
        for(int i = 0 ; i < num; i++){
            if(i==0 || i==1){
                answer.add(1);
            } else{
                answer.add(answer.get(i-2) + answer.get(i-1));
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for(int i = 0; i<solution(num).size();i++){
            if(i==solution(num).size()-1){
                System.out.print(solution(num).get(i));
            } else {
                System.out.print(solution(num).get(i) + " ");
            }
        }
    }
}
