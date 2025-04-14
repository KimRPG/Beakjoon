import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N - 1];
        long[][] dp = new long[N - 1][21];
        for (int i = 0; i < N-1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = Integer.parseInt(st.nextToken());
        dp[0][arr[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (dp[i - 1][j] != 0) {
                    if (j - arr[i] >= 0) {
                        dp[i][j - arr[i]] += dp[i - 1][j];
                    }
                    if (j + arr[i] < 21) {
                        dp[i][j + arr[i]] += dp[i - 1][j];
                    }
                }
            }
        }

        System.out.println(dp[N - 2][answer]);
    }
}