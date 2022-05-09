package TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoPointersAlgorithm {
    public static List<Integer> solution(int n, int m, int[] a, int[] b){
        List<Integer> answer = new ArrayList<Integer>();
        int p1 =0, p2=0;
        while(p1<n && p2<m){
            if(a[p1]<b[p2]) answer.add(a[p1++]);
            else answer.add(b[p2++]);
        }
        while(p1<n) answer.add(a[p1++]);
        while(p2<m) answer.add(b[p2++]);
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 = new int[n1];
        for(int i =0; i<n1; i++){
            arr1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i] = in.nextInt();
        }
        System.out.println(solution(n1,n2,arr1,arr2));
    }
}
