import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Stack<int[]> stack = new Stack();
        for(int i = 0; i < n; i++){
            int cur = numbers[i];
            
            while(!stack.isEmpty() && stack.peek()[0] < cur){
                int[] node = stack.pop();
                answer[node[1]] = cur;
            }
            
            stack.push(new int[]{numbers[i],i});
        }
        while(!stack.isEmpty()){
            answer[stack.pop()[1]] = -1;
        }
        return answer;
    }
    
}