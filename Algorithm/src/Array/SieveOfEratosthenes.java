package Array;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class SieveOfEratosthenes {
//    public static int solution(int num){
//        int answer = 0;
//        double sqrt = Math.sqrt(num);
//        List<String> arr = new ArrayList<String>();
//        for(int i = 1 ; i <= num ; i++){
//            arr.add(Integer.toString(i));
//        }
//        for(int i = 1; i<=num/2; i++){
//            for(int j = 2; j<=sqrt; j++) {
//                if (i * j <= num && i*j!=2) {
//                    arr.remove(Integer.toString(i * j));
//                }
//            }
//        }
//        answer = arr.size();
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int input = in.nextInt();
//        System.out.println(solution(input));
//    }
//}

// 위의 풀이는 TimeLimit 에러남

import java.util.Scanner;

public class SieveOfEratosthenes {
    public static int solution(int n){
        int answer = 0;
        // 동적 배열은 0으로 초기화됨
        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++){
            if(ch[i]==0){
                answer++;
                for(int j = i; j<=n; j=j+i){
                    ch[j]=1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        System.out.println(solution(input));
    }
}