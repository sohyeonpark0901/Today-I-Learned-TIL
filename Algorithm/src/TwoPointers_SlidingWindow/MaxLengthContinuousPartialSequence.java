//package TwoPointers_SlidingWindow;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class MaxLengthContinuousPartialSequence {
//    public static int solution(int n, int m, int[] arr){
//        int answer = 0;
//        List<Integer> index_zero = new ArrayList<Integer>();
//        int lt =0;
//        int rt = m;
//        int index_zero_lt = 0;
//        int tmp_result = 0;
//        for(int i = 0; i< n; i++){
//            if(arr[i] == 0) index_zero.add(i);
//        }
//
//        while(rt<index_zero.size()){
//            if(lt!=0){
//                tmp_result = index_zero.get(rt) - (lt+1);
//            } else {
//                tmp_result = index_zero.get(rt) - lt;
//            }
//            rt++;
//            lt = index_zero.get(index_zero_lt);
//            index_zero_lt++;
//            answer = Math.max(tmp_result,answer);
//        }
//        return answer;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] arr = new int[n];
//        for(int i=0; i<n;i++){
//            arr[i] = in.nextInt();
//        }
//        System.out.println(solution(n,m,arr));
//    }
//}

//또다른 풀이
package TwoPointers_SlidingWindow;
import java.util.Scanner;

public class MaxLengthContinuousPartialSequence {
    public static int solution(int n, int m, int[] arr){
        int answer = 0, cnt = 0, lt=0;
        for(int rt = 0; rt<n; rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>m){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n,m,arr));
    }
}
