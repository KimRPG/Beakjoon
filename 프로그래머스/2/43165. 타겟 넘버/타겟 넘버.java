import java.util.*;

class Solution {
    
    boolean[] isVisit;
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
  public int dfs(int[] numbers, int target, int depth, int currentSum) {
        if (depth == numbers.length) {
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        

        int add = dfs(numbers, target, depth + 1, currentSum + numbers[depth]);
        
        int subtract = dfs(numbers, target, depth + 1, currentSum - numbers[depth]);

        return add + subtract;
    }
}