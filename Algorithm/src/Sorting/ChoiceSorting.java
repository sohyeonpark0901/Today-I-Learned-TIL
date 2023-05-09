package Sorting;

import java.util.Scanner;

public class ChoiceSorting {
    public static int[] solution(int n, int[] arr){
        for(int i =0; i<arr.length-1;i++){
            int idx = i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j]<arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = in.nextInt();
        }
        int[] result = solution(N,arr);
        for(int i: result) System.out.print(i+" ");
    }
}
