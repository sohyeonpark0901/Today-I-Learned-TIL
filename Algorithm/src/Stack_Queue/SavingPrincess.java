//package Stack_Queue;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class SavingPrincess {
//    public static int solution(int n, int k){
//        int answer = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        int tmp = 0;
//        int count = 0;
//        for(int i=1; i<=n; i++){
//            queue.add(i);
//        }
//        while(queue.size()>1){
//            tmp = queue.remove();
//            count++;
//            if(count != k) queue.add(tmp);
//            else count = 0;
//        }
//        answer = queue.peek();
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int K = in.nextInt();
//        System.out.println(solution(N,K));
//    }
//}

//또다른 풀이
package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SavingPrincess {
    public static int solution(int n, int k){
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1;i<=n;i++) Q.offer(i);
        while(!Q.isEmpty()){
            for(int i=1;i<k;i++) Q.offer(Q.poll());
            Q.poll();
            if(Q.size()==1) answer = Q.poll();
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        System.out.println(solution(N,K));
    }
}
