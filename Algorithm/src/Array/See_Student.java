package Array;

import java.util.Scanner;

public class See_Student {
    public static int solution(int count, String str){
        int answer = 1 ;
        String[] arr = str.split(" ");
        int point = Integer.parseInt(arr[0]);
        for(int i = 1; i<count ; i++){
            if(point<Integer.parseInt(arr[i])){
                point = Integer.parseInt(arr[i]);
                answer ++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in. nextInt();
        in.nextLine();
        String str = in.nextLine();
        System.out.println(solution(num,str));
    }
}
