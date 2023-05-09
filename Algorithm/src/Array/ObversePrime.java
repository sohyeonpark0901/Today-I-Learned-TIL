package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObversePrime {
    public static List<Integer> solution(int n, String s){
        List<Integer> answer = new ArrayList<Integer>();
        String[] arr = s.split(" ");
        String tmp_s;
        int tmp_n = 0;
        for(String x : arr){
            StringBuilder sb = new StringBuilder(x);
            tmp_s = sb.reverse().toString();
            tmp_n = Integer.parseInt(tmp_s);
            if((tmp_n==2 || isPrime(tmp_n) )&& tmp_n!=1) answer.add(tmp_n);
        }
        return answer;
    }
    public static boolean isPrime(int n){
        boolean result = true;
        double sqrt = Math.sqrt(n);
        for(int i = 2 ; i<= sqrt ; i++){
            if(n%i==0){
                result = false;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String input = in.nextLine();
        List<Integer> result = solution(N,input);
        for(int i = 0 ; i < result.size(); i++){
            if(i!= result.size()-1){
                System.out.print(result.get(i)+" ");
            }else{
                System.out.print(result.get(i));
            }
        }
    }
}
