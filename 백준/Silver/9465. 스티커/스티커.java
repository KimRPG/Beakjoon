import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] dp = new int[100_000][2];
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dp[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                dp[j][1] = Integer.parseInt(st.nextToken());
            }
            if (n == 1) {
                int ans = Math.max(dp[n - 1][0], dp[n - 1][1]);
                sb.append(ans).append("\n");
                continue;
            }
            dp[1][0] += dp[0][1];
            dp[1][1] += dp[0][0];

            for (int j = 2; j < n; j++) {
                dp[j][0] = Math.max(Math.max(dp[j - 1][1] + dp[j][0], dp[j - 2][0] + dp[j][0]), dp[j - 2][1] + dp[j][0]);
                dp[j][1] = Math.max(Math.max(dp[j - 1][0] + dp[j][1], dp[j - 2][0] + dp[j][1]), dp[j - 2][1] + dp[j][1]);
            }
            int ans = Math.max(dp[n - 1][0], dp[n - 1][1]);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
    
}

