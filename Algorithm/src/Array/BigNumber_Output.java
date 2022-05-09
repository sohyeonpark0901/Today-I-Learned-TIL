package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigNumber_Output {
    public static List<String> solution(int num, String str){
        List<String> answer = new ArrayList<String>();
        String[] arr_tmp = str.split(" ");
        answer.add(arr_tmp[0]);
        for(int i = 1; i < num; i++){
            if(Integer.parseInt(arr_tmp[i-1]) < Integer.parseInt(arr_tmp[i])){
                answer.add(arr_tmp[i]);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.nextLine();
        String in_arr = in.nextLine();
        List<String> result = solution(number,in_arr);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
