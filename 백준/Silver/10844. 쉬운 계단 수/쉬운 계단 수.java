import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[100][10];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 9; j++) {
                dp[i][j] = dp[i - 1][j - 1] % 1_000_000_000 + dp[i - 1][j + 1] % 1_000_000_000;

            }
            dp[i][0] = dp[i - 1][1];
            dp[i][9] = dp[i - 1][8];
        }

        int N = Integer.parseInt(br.readLine());
        long ans = 0;
        for (int i = 1; i < 10; i++) {
            ans += dp[N - 1][i];
        }
        System.out.println(ans % 1_000_000_000);

    }
}