import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        int len = words.length;
        int turn = 0;
        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        char last = words[0].toCharArray()[words[0].length() - 1];
        for(int i = 1; i<len; i++){
            if(set.contains(words[i])) {
                turn = i+1;
                break;
            }
            if(last != words[i].toCharArray()[0]){
                turn = i+1;
                break;
            }else{
                last = words[i].toCharArray()[words[i].length() - 1];
                set.add(words[i]);
            }
        }
        
        if(turn ==0){
            answer = new int[]{0,0};
        }else{
            int person = (turn % n == 0) ? n : (turn % n);
             int round = (turn % n == 0) ? turn / n : (turn / n + 1);
            answer = new int[]{person, round};
        }   
        return answer;
    }
}