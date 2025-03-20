import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 0; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[j] = (dp[j - 1] + dp[j]) % 1_000_000_000;
            }
        }
        System.out.println(dp[N]);

    }

}