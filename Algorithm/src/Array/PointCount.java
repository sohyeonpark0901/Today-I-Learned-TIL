package Array;

import java.util.Scanner;

public class PointCount {
    public static int solution(int n, String s){
        int answer = 0;
        String[] arr = s.split(" ");
        int count = 0;
        for(int i = 0; i<n; i++){
            if(Integer.parseInt(arr[i])==1){
                count++;
                answer+=count;
            }else{
                count = 0;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        System.out.println(solution(N,s));
    }
}
