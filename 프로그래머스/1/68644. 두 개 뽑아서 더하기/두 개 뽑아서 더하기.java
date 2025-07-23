import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        TreeSet<Integer> set = new TreeSet<>();
        int len = numbers.length;
        for(int i = 0 ; i < len; i++){
            for(int j = i+1; j < len ; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}