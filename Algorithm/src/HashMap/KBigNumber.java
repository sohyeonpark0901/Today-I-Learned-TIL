//package HashMap;
//
//import java.util.*;
//
//public class KBigNumber {
//    public static int solution(int N, int k, Integer[] arr){
//        int answer = 0;
//        Arrays.sort(arr,Collections.reverseOrder());
//        TreeSet<Integer> sum = new TreeSet<Integer>(Collections.reverseOrder());
//        int tmp_sum = 0;
//        int lt = 0;
//        while(lt<=N-k){
//            tmp_sum += arr[lt];
//            tmp_sum += arr[lt+1];
//            for(int rt = lt+k-1;rt<N;rt++){
//                sum.add(tmp_sum+arr[rt]);
//            }
//            tmp_sum = 0;
//            lt++;
//        }
//        int count = 0;
//        Iterator iter = sum.iterator();	// Iterator 사용
//        while(iter.hasNext()) {//값이 있으면 true 없으면 false
//            count++;
//            answer = (Integer)iter.next();
//            if(count==k) {
//                break;
//            }
//        }
//        if(count!=k) answer = -1;
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int k = in.nextInt();
//        Integer[] arr = new Integer[N];
//        for(int i=0;i<N;i++){
//            arr[i] = in.nextInt();
//        }
//        System.out.println(solution(N,k,arr));
//    }
//}
// 위의 풀이는 오답
package HashMap;

import java.util.*;

public class KBigNumber {
    public static int solution(int n, int k, int[] arr){
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<Integer>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int l=j+1;l<n;l++){
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int cnt = 0;
        for(int x : Tset){
            cnt++;
            if(cnt==k) return x;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solution(N,k,arr));
    }
}
