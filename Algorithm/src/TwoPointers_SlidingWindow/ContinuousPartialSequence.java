//package TwoPointers_SlidingWindow;
//
//import java.util.Scanner;
//
//public class ContinuousPartialSequence {
//    public static int solution(int n, int m, int[] arr){
//        int answer = 0;
//        int sum = 0;
//        int pointer1 = 0;
//        int pointer2 = 1;
//        while(pointer1<n){
//            sum += arr[pointer1];
//            if(sum>m){
//                sum = 0;
//                pointer1 = pointer2;
//                pointer2++;
//            } else if(sum==m){
//                answer++;
//                sum = 0;
//                pointer1 = pointer2;
//                pointer2++;
//            } else{
//                pointer1++;
//            }
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] arr = new int[n];
//        for(int i =0; i<n; i++){
//            arr[i] = in.nextInt();
//        }
//        System.out.println(solution(n, m, arr));
//    }
//}
// 또다른 풀이
package TwoPointers_SlidingWindow;

import java.util.Scanner;

public class ContinuousPartialSequence {
    public static int solution(int n, int m, int[] arr){
        int answer = 0, sum=0, lt=0;
        for(int rt=0; rt<n; rt++){
            sum+=arr[rt];
            if(sum==m) answer++;
            while(sum>=m) {
                sum-=arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }
}
