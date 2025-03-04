import java.util.*;
import java.io.*;

public class Main{
    static int[][] graph;
    static int[][][] dp;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        // 가로 0, 세로 1, 대각선 2
        dp = new int[N][N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                if (graph[i][j] == 1) continue;
                for (int k = 0; k < 3; k++) {
                    if (k == 0) {
                        dp[i][j][k] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    } else if (i > 0 && k == 1) {
                        dp[i][j][k] = dp[i - 1][j][1] + dp[i - 1][j][2];
                    } else if (i > 0) {
                        if (graph[i - 1][j] == 0 && graph[i][j - 1] == 0 && graph[i - 1][j - 1] == 0) {
                            dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += dp[N - 1][N - 1][i];
        }
        System.out.println(ans);
    }
}