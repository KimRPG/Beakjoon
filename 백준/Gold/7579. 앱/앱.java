import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mem = new int[N];
        int[] time = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        int totalCost = 0;
        for (int i = 0; i < N; i++) totalCost += time[i];

        int[] dp = new int[totalCost + 1];

        for (int i = 0; i < N; i++) {
            for (int c = totalCost; c >= time[i]; c--) {
                dp[c] = Math.max(dp[c], dp[c - time[i]] + mem[i]);
            }
        }

// 최소 비용 찾기
        for (int c = 0; c <= totalCost; c++) {
            if (dp[c] >= M) {
                System.out.println(c);
                break;
            }
        }
    }
}
