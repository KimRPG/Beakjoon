import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[30][30];
        dp[0][0] = 1;
        for (int i = 1; i < 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        System.out.println(dp[N - 1][M - 1]);

    }
}