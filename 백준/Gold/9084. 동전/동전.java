import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int ia = 0; ia < T; ia++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coin = new int[N];
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[M+1];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                int cur = coin[i];
                for (int j = cur; j <= M; j++) {
                    dp[j] = dp[j] + dp[j - cur];
                }
            }
            sb.append(dp[M]).append("\n");
        }
        System.out.println(sb);
    }
}