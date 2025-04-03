import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE-100);
        dp[N - 1] = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 1; j <= arr[i]; j++) {
                if (i + j < N) {
                    dp[i] = Math.min(dp[i], dp[i + j] + 1);
                }
            }
        }
        System.out.println(dp[0] == Integer.MAX_VALUE-100 ? -1 : dp[0]);


    }

}
