import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int pre = -1;
        for(int num : arr){
            if(pre == num) continue;
            pre = num;
            list.add(num);
        }


        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}