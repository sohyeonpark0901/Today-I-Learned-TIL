package Array;

import java.util.Scanner;

public class NumberExtraction {
    public static int solution(String s){
        int answer = 0;
        String restr = s.replaceAll("[^0-9]","");
        answer = Integer.parseInt(restr);
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solution(s));
    }
}
