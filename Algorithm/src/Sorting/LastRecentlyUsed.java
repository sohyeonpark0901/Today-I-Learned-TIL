package Sorting;

import java.util.*;
// 삽입정렬로 다시풀어보기
public class LastRecentlyUsed {
    public static int[] solution(int s, int n, int[] arr){
        int[] answer = new int[s];


        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] result = solution(s,n,arr);
        for(int i=0;i<n;i++) arr[i] = in.nextInt();
        for(int i=0;i<s;i++) System.out.print(result[i]+" ");
    }
}
