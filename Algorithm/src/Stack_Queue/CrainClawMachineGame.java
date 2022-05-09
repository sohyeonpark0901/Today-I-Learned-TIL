package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class CrainClawMachineGame {
    public static int solution(int n, int[][] arr1, int m, int[] arr2){
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr1[j][arr2[i]-1]!=0) {
                    if(!bucket.isEmpty() && bucket.peek() == arr1[j][arr2[i]-1]) {
                        answer = answer+2;
                        bucket.pop();
                    }
                    else bucket.push(arr1[j][arr2[i]-1]);
                    arr1[j][arr2[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[][] input1 = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                input1[i][j] = in.nextInt();
            }
        }
        int M = in.nextInt();
        int[] moves = new int[M];
        for(int i=0;i<M;i++){
            moves[i] = in.nextInt();
        }
        System.out.println(solution(N,input1,M,moves));
    }
}
