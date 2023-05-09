package Array;
/*
import java.util.Scanner;

public class GratingMaxSum {
    public static int solution(int n,String[][] arr){
        int answer = 0;
        int sum1 = 0; //행
        int sum2 = 0; //렬
        int sum3 = 0; // 원래 대각선
        int sum4 = 0; // 반대 대각선
        // 행들의 합
        for(int i =0; i< n; i++){
            for(int j=0;j<n;j++){
               sum1 += Integer.parseInt(arr[i][j]);
               sum2 += Integer.parseInt(arr[j][i]);
               if(i==j){
                   sum3+=Integer.parseInt(arr[i][j]);
               }
               if(i+j+2==n){
                   sum4+=Integer.parseInt(arr[i][j]);
               }
            }
            if(answer<=sum1){
                answer = sum1;
            }
            if(answer<=sum2){
                answer = sum2;
            }
            sum1 = 0;
            sum2 = 0;
        }
        if(answer<=sum3){
            answer = sum3;
        }
        if(answer<=sum4){
            answer = sum4;
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        String[][] array = new String[num][num];
        for(int i = 0 ; i<num; i++){
            String s = in.nextLine();
             array[i]= s.split(" ");
        }
        System.out.println(solution(num,array));
    }
}*/

import java.util.Scanner;

//또다른 풀이
public class GratingMaxSum {
    public static int solution(int n, int[][] arr){
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i =0; i<n; i++){
            sum1=sum2=0;
            for(int j=0; j<n; j++){
                sum1 +=arr[i][j];
                sum2 +=arr[j][i];
            }
            answer =Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1=sum2=0;
        for(int i=0;i<n;i++){
            sum1+=arr[i][i];
            sum2+=arr[i][n-i-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(n,arr));
    }
}