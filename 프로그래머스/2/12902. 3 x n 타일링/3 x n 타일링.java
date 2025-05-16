class Solution {
    public int solution(int n) {
        long[] dp = new long[n];
        dp[0] = 0;
        dp[1] = 3;
        dp[2] = 0;
        dp[3] = 11;
        for(int i = 4; i < n; i++){
            if(i%2 == 1){
            dp[i] = (dp[i-2] * 3) % 1_000_000_007;
            for(int j = i-4; j>0 ; j = j-2){
                dp[i] += (dp[j] * 2) % 1_000_000_007;
            }
            dp[i]= (dp[i]+2) % 1_000_000_007;
            }
        }
        return (int)dp[n-1];
    }
}