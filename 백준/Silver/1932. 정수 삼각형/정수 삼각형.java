import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        if (N == 1) {
            System.out.println(dp[0][0]);
            return;
        }

            dp[1][0] = arr[0][0] + arr[1][0];
            dp[1][1] = arr[0][0] + arr[1][1];
            if (N == 2) {
            System.out.println();
            System.out.println(Math.max(dp[1][0], dp[1][1]));
            return;
        }
        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + arr[i][j], dp[i - 1][j] + arr[i][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(dp[N - 1][i], ans);
        }
        System.out.println(ans);
    }

}
