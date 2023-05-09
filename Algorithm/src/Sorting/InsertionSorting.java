package Sorting;

import java.util.Scanner;

public class InsertionSorting {
    public static int[] solution(int N, int[] arr){
        for(int i=1; i<N; i++){
            int tmp = arr[i], j;
            for(j=i-1;j>=0;j--){
                if(arr[j]>tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
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
        for(int i: result) System.out.print(i + " ");
    }
}
