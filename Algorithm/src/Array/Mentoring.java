package Array;

import java.util.Scanner;

//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Mentoring {
//    public static int solution(int x, int y, String[][] arr){
//        int answer = 0 ;
//        int[] student = new int[4];
//        List<Integer> result = new ArrayList<Integer>();
//        for(int i=0; i<y; i++){
//            for(int j=0; j<x; j++){
//                int k = j+1;
//                while(j!=x-1 && k<x){
//                    result.add(Integer.parseInt(arr[i][j]+arr[i][k]));
//                    k++;
//                }
//            }
//        }
//        for(int i = 0; i<result.size(); i++){
//            System.out.print(result.get(i)+" ");
//        }
//        System.out.println();
//        for(int i = 0; i< result.size();i++){
//            StringBuffer sb = new StringBuffer(Integer.toString(result.get(i)));
//            String reverse = sb.reverse().toString();
//            int rev = Integer.parseInt(reverse);
//            if(result.containsAll(Arrays.asList(rev))){
//                result.removeAll(Arrays.asList((Integer)rev, (Integer)result.get(i)));
//            }
//        }
//
//        for(int i = 0; i<result.size(); i++){
//            System.out.print(result.get(i)+" ");
//        }
//
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String input1 = in.nextLine();
//        String[] in_arr;
//        in_arr = input1.split(" ");
//        String[][] in_arr2 = new String[Integer.parseInt(in_arr[0])][Integer.parseInt(in_arr[1])];
//        for(int i = 0; i<Integer.parseInt(in_arr[1]);i++){
//            String s = in.nextLine();
//            in_arr2[i] = s.split(" ");
//        }
//        System.out.println(solution(Integer.parseInt(in_arr[0]), Integer.parseInt(in_arr[1]), in_arr2));
//    }
//}
// 위의 풀이는 오답

public class Mentoring {
    public static int solution(int n, int m, int[][] arr){
        int answer = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int cnt=0;
                for(int k=0;k<m;k++){
                    int pi=0, pj=0;
                    for(int s=0;s<n;s++){
                        if(arr[k][s]==i) pi=s;
                        if(arr[k][s]==j) pj=s;
                    }
                    if(pi<pj) cnt++;
                }
                if (cnt==m) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(solution(n,m,arr));
    }
}