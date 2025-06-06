import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[10];
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 9; j > 0; j--) {
                for (int k = 0; k < j; k++) {
                    dp[j] =  (dp[j]+ dp[k]) % 10007;
                }
            }
        }

        System.out.println(dp[9]);
    }

}

