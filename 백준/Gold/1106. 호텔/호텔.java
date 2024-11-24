import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 한 번에 얻을 수 있는 고객의 수는 100보다 작거나 같다
        // C명 이상이면 되므로 C + 101 까지 배열에 담는다
        int[] dp = new int[C + 101];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            int cost = arr[i][0];
            int value = arr[i][1];
            for (int j = value; j < C + 101; j++) {
                if (dp[j - value] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j - value] + cost, dp[j]);
                }
            }
        }

        // C명 이상 중에 최솟값 탐색
        int ans = Integer.MAX_VALUE;
        for (int i = C; i < C + 101; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);

    }

}