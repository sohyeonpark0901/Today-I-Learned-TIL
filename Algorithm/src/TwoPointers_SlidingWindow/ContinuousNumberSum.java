//package TwoPointers_SlidingWindow;
//
//import java.util.Scanner;
//
//public class ContinuousNumberSum {
//    public static int solution(int n){
//        int answer = 0;
//        int pointer1 = 1;
//        int pointer2 = 2;
//        int sum = 0;
//        while(pointer1<n){
//            sum+=pointer1;
//            if(sum>n){
//                sum = 0;
//                pointer1 = pointer2;
//                pointer2++;
//            } else if(sum==n){
//                answer++;
//                sum=0;
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
//        System.out.println(solution(n));
//    }
//}

// 또다른 풀이1
//package TwoPointers_SlidingWindow;
//
//import java.util.Scanner;
//
//public class ContinuousNumberSum {
//    public static int solution(int n){
//        int answer = 0, sum=0, lt=0;
//        int m=n/2+1;
//        int[] arr = new int[m];
//        for(int i=0; i<m; i++) arr[i] = i+1;
//        for(int rt=0;rt<m;rt++){
//            sum+=arr[rt];
//            if(sum==n) answer++;
//            while(sum>=n){
//                sum-=arr[lt++];
//                if(sum==n) answer++;
//            }
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        System.out.println(solution(n));
//    }
//}

//또다른 풀이 - Math
package TwoPointers_SlidingWindow;
import java.util.Scanner;

public class ContinuousNumberSum {
    public static int solution(int n){
        int answer = 0, cnt=1;
        n--;
        while(n>0){
            cnt++;
            n=n-cnt;
            if(n%cnt==0) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(solution(n));
    }
}