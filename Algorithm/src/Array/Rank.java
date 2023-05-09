package Array;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Rank {
//    public static List<Integer> solution(int n, String s){
//        List<Integer> answer = new ArrayList<Integer>();
//        String[] arr = s.split(" ");
//        int max = Integer.parseInt(arr[0]);
//        int point = 1;
//        answer.add(point);
//        for(int i = 1; i<n; i++){
//            point++;
//            if(max<Integer.parseInt(arr[i])){
//                for(int j=0;j<i;j++){
//                    answer.set(j, (answer.get(j))+1);
//                }
//                answer.add(1);
//                max=Integer.parseInt(arr[i]);
//            }else if(max==Integer.parseInt(arr[i])){
//                answer.add(answer.get(i-1));
//            } else{
//                answer.add(point);
//            }
//        }
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        in.nextLine();
//        String s = in.nextLine();
//        List<Integer> result = solution(N,s);
//        for(int i = 0; i<result.size();i++){
//            if(i==result.size()-1){
//                System.out.print(result.get(i));
//            }else{
//                System.out.print(result.get(i)+" ");
//            }
//        }
//    }
//}
// 위의 풀이는 오답
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rank {
    public static int[] solution(int n, int[] arr){
        int[] answer = new int[n];
        for(int i = 0; i<n; i++){
           int cnt=1;
           for(int j=0;j<n;j++){
               if(arr[j]>arr[i]) cnt++;
           }
           answer[i]=cnt;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = in.nextInt();
        }
        for(int x:solution(n,arr)) System.out.println(x+" ");
    }
}
