//package Stack_Queue;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class EmergencyRoom {
//    public static int solution(int n, int k, int[] arr){
//        int answer = 0;
//        int criteria = arr[k];
//        boolean flag = true;
//        Queue<Integer> queue = new LinkedList<>();
//        int plus_count = 0;
//        for(int i = 0; i< arr.length; i++) {
//            if(i<k&& arr[i] == criteria) plus_count++;
//            queue.add(arr[i]);
//        }
//        int tmp = queue.remove();
//        while(true){
//            for(int i : queue){
//                if(tmp<i){
//                    queue.add(tmp);
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag) answer++;
//            if(tmp == criteria && flag == true) break;
//            tmp = queue.remove();
//            flag = true;
//        }
//        answer += plus_count;
//        return answer;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int N = in.nextInt();
//        int M = in.nextInt();
//        int[] arr = new int[N];
//        for(int i=0;i<N;i++){
//            arr[i] = in.nextInt();
//        }
//        System.out.println(solution(N, M, arr));
//    }
//}
// 위의 풀이는 오답이라고 나옴
package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class EmergencyRoom {
    public static int solution(int n, int m, int[] arr){
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for(int i=0;i<n;i++) Q.offer(new Person(i,arr[i]));
        while(!Q.isEmpty()){
            Person tmp = Q.poll();
            for(Person x: Q){
                if(x.priority > tmp.priority){
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id==m) return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = in.nextInt();
        }
        System.out.println(solution(N, M, arr));
    }
}
