package String;/*
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class String_9 {
    public static List<Integer> Solution(String str){
        List<Integer> answer = new ArrayList<Integer>();
        String str1 = str.split(" ")[0];
        String str2 = str.split(" ")[1];
        List<Integer> index_arr = new ArrayList<Integer>();
        int start = 0;
        int index = str1.indexOf(str2);
        while(index!=-1){
            index_arr.add(index);
            index = str1.indexOf(str2,index+str2.length());
        }

        for(int i = 0 ; i < str1.length(); i++){
            if(start+1!=index_arr.size()){
                int point = index_arr.get(start) + index_arr.get(start+1);
                if(start<index_arr.size()) {
                    if (i < index_arr.get(start)) {
                        answer.add(index_arr.get(start) - i);
                    } else if (i > index_arr.get(start) && i < index_arr.get(start + 1)) {
                        if (i <= point / 2) {
                            answer.add(i - index_arr.get(start));
                        } else {
                            answer.add(index_arr.get(start + 1) - i);
                        }
                    } else if (i == index_arr.get(start) || i == index_arr.get(start + 1)) {
                        answer.add(0);
                    } else {
                        start++;
                        answer.add(i-index_arr.get(start));
                    }
                }
            } else{
                answer.add(Math.abs(i-index_arr.get(start)));
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        List<Integer> result = Solution(input);
        for(int i = 0; i< result.size(); i++){
            if(i== result.size()-1){
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i)+" ");
            }
        }
    }
}
*/

// 위에는 오답이므로 강의 내용 정리
import java.util.Scanner;

public class String_10 {
    public static int[] Solution(String s, char t){
        int[] answer = new int[s.length()];
        int p = 1000;
        for(int i = 0 ; i<s.length(); i++){
            if(s.charAt(i)==t){
                p=0;
                answer[i]=p;
            }else{
                p++;
                answer[i]=p;
            }
        }
        p = 1000;
        for(int i = s.length()-1 ; i>=0; i--){
            if(s.charAt(i)==t){
                p=0;
            }else{
                p++;
                answer[i]=Math.min(answer[i],p);
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0); // 문자 한개 읽을 때
        for(int x: Solution(str,c)){
            System.out.println(x+" ");
        }
    }
}
