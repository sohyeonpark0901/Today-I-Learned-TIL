//package TwoPointers_SlidingWindow;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class HighestSales {
//    public static int solution(int n, int d, int[] arr){
//       int p1 = 0;
//       int p2 = 0;
//       int count = 0;
//       int tmp = 0;
//       int max = 0;
//       while(p1<n){
//           tmp += arr[p1];
//           count++;
//           if(count==d){
//               if(max<tmp) max = tmp;
//               count = 0;
//               tmp = 0;
//               p2++;
//               p1 = p2;
//           } else {
//               p1++;
//           }
//       }
//       return max;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int day = in.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++){
//            arr[i] = in.nextInt();
//        }
//        System.out.println(solution(n,day,arr));
//    }
//}
// 위의 풀이는 time 초과됨
/*
* Sliding window
* */
package TwoPointers_SlidingWindow;

import java.util.Arrays;
import java.util.Scanner;

public class HighestSales {
    public static int solution(int n, int k, int[] arr){
        int answer = 0;
        int sum = 0;
        for(int i=0;i<k;i++) sum+=arr[i];
        answer = sum;
        for(int i=k;i<n;i++) {
            sum+=(arr[i] - arr[i-k]);
            answer = Math.max(sum,answer);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int day = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n,day,arr));
    }
}