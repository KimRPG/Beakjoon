import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = {1, 10, 45, 120, 210, 252, 210, 120, 45, 10, 1};
        for (int i = 1; i < N; i++) {
            for (int j = 9; j > 0; j--) {
                dp[j] = (dp[j] + dp[j - 1]) % 10007;
            }
        }

        System.out.println(dp[9]);
    }

}

