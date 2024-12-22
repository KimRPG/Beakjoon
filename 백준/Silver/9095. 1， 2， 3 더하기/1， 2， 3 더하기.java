import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 1; i < 12; i++) {
            if(dp[i] == 0) dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(dp[a]).append("\n");
        }
        System.out.println(sb);
    }
}