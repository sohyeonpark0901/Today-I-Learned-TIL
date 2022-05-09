package Array;

import java.util.Scanner;
//public class Mountaintop {
//    public static int solution(int n, String[][] arr){
//        int answer = 0;
//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n; j++){
//                if(Integer.parseInt(arr[i][j])>Integer.parseInt(arr[i-1][j] )
//                        && Integer.parseInt(arr[i][j]) > Integer.parseInt(arr[i+1][j])
//                        && Integer.parseInt(arr[i][j]) > Integer.parseInt(arr[i][j-1])
//                        && Integer.parseInt(arr[i][j]) > Integer.parseInt(arr[i][j+1]) ){
//                    answer++;
//                }
//            }
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String[][] arr = new String[n+2][n+2];
//        for(int i = 0 ; i<n+2; i++){
//            arr[0][i] = "0";
//            arr[n+1][i] = "0";
//        }
//        for(int i = 0; i<n; i++){
//            String s = in.nextLine();
//            s = "0 "+s+" 0";
//            arr[i+1] = s.split(" ");
//        }
//
//        System.out.println(solution(n,arr));
//    }
//}
// 위의 풀이는 RunTimeError발생
public class Mountaintop {
    public static int solution(int n, int arr[][]){
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,-1,0};
        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                boolean flag = true;
                for(int k=0;k<4;k++){
                    int nx=i+dx[k];
                    int ny=i+dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]>=arr[i][j]){
                        flag = false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println();
    }
}