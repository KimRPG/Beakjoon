import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        int[] dp = new int[length+1];
        for(int i = 0; i < length; i++){
            for(int j = i; j > 0 ; j--){
                dp[j] = Math.max(dp[j-1],dp[j])+ triangle[i][j];
            }
            dp[0] += triangle[i][0];
        }
        for(int i = 0; i < length; i++){
            answer= Math.max(dp[i],answer);
        }
        return answer;
    }
}