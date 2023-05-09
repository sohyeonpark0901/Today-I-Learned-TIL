//package HashMap;
//
//import java.util.*;
//
//public class TypeOfSales {
//    public static List<Integer> solution(int n1, int n2, int[] arr){
//        List<Integer> answer= new ArrayList<Integer>();
//        Map<Integer,Integer> tmp = new HashMap<Integer,Integer>();
//        int lt =0;
//        int rt = n2;
//        int count =0;
//        while(rt<=n1){
//            while(lt<rt){
//                if(!tmp.containsKey(arr[lt])){
//                    tmp.put(arr[lt],tmp.getOrDefault(arr[lt],0));
//                    count++;
//                }
//                lt++;
//            }
//            answer.add(count);
//            count = 0;
//            tmp.clear();
//            rt++;
//            lt = rt - n2;
//
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num1 = in.nextInt();
//        int num2 = in.nextInt();
//        int[] arr = new int[num1];
//        for(int i=0;i<num1;i++){
//            arr[i] = in.nextInt();
//        }
//        List<Integer> result = solution(num1,num2,arr);
//        for(int i =0; i<result.size();i++){
//            System.out.print(result.get(i)+" ");
//        }
//    }
//}
//// 위의 풀이는 TimeLimit 에러났음
package HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TypeOfSales {
    public static List<Integer> solution(int n, int k, int[] arr){
        List<Integer> answer = new ArrayList<Integer>();
        HashMap<Integer,Integer> HM= new HashMap<Integer,Integer>();
        for(int i =0;i<k-1;i++){
            HM.put(arr[i], HM.getOrDefault(arr[i],0)+1);
        }
        int lt = 0;
        for(int rt=k-1; rt<n ;rt++){
            HM.put(arr[rt],HM.getOrDefault(arr[rt],0)+1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt])-1);
            if(HM.get(arr[lt])==0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solution(n,k,arr));
    }
}