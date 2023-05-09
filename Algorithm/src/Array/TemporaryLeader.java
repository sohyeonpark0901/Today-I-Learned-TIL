package Array;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class TemporaryLeader {
//    public static int solution(int n, String[][] arr){
//        int answer = 0;
//        int[][] arr_tmp = new int[n][n];
//        int max = 0;
//        String[][] arr_con = new String[n][n];
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                arr_con[i][j] = arr[j][i];
//            }
//        }
//
//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<n; j++){
//                int index = Arrays.asList(arr_con[i]).indexOf(arr_con[i][j]);
//                if(index != -1 && index !=j){
//                    arr_tmp[j][i]=1;
//                    arr_tmp[index][i] = 1;
//                }
//            }
//        }
//
//        int tmp = 0;
//        for(int i = 0; i<n; i++){
//            for(int j = 0; j<n; j++){
//                tmp += arr_tmp[i][j];
//            }
//            if(tmp>max){
//                answer = i;
//                max = tmp;
//            }
//            tmp = 0;
//        }
//        return answer+1;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String[][] arr = new String[n][n];
//        for(int i = 0; i<n; i++){
//            String s = in.nextLine();
//            arr[i] = s.split(" ");
//        }
//        System.out.println(solution(n,arr));
//    }
//}
// 위의풀이는 오답이라고 나옴

import java.util.Scanner;

public class TemporaryLeader {
    public static int solution(int n, int[][] arr){
        int answer = 0, max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            int cnt=0;
            for(int j=1; j<=n; j++){
                for(int k=1;k<=5;k++){
                    if(arr[i][k]==arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max=cnt;
                answer=i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n+1][6];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=5;j++){
                arr[i][j] = in.nextInt();
            }
        }
    }
}