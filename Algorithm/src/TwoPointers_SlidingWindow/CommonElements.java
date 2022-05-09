package TwoPointers_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommonElements {
    public static List<Integer> solution(int n1, int arr1[], int n2, int arr2[]){
        List<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 =0, p2=0;
        while(p1<n1 && p2<n2){
            if(arr1[p1]<arr2[p2]){
                p1++;
            }else if(arr1[p1]==arr2[p2]){
                answer.add(arr1[p1]);
                p1++;
                p2++;
            } else{
                p2++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0; i<n1; i++){
            arr1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0; i<n2; i++){
            arr2[i] = in.nextInt();
        }
        List<Integer> result = solution(n1,arr1,n2,arr2);
        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
