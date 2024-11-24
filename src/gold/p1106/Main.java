package gold.p1106;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 최소 유치해야 할 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시의 개수

        int[] dp = new int[101]; // dp 배열 (최대 100,000명까지 처리)
        Arrays.fill(dp, Integer.MAX_VALUE); // 초기값을 큰 값으로 설정
        dp[0] = 0; // 고객을 0명 유치하기 위한 비용은 0

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken()); // 광고 비용
            int customer = Integer.parseInt(st.nextToken()); // 해당 광고로 유치 가능한 고객 수

            for (int j = customer; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - customer] + cost);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);
    }
}
