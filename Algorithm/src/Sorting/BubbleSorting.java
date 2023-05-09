package Sorting;

import java.util.Scanner;

public class BubbleSorting {
    public static int[] solution(int n, int[] arr){
        int tmp = 0;
        for(int i= arr.length-1; i>=0; i--){
            for(int j=0; j<n-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = in.nextInt();
        int[] result = solution(N,arr);
        for(int i: result) System.out.print(i+" ");
    }
}
