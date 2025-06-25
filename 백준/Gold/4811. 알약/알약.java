import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[][] dp = new long[30][30];
        for (int i = 0; i < 30; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                if (j <= i) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
                else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                break;
            }
            else{
                sb.append(dp[a - 1][a - 1]).append("\n");
            }
        }
        System.out.println(sb);
    }

}