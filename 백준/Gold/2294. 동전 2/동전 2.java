import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k+1];
        Arrays.fill(dp, 999999);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            int value = coin[i];
            for (int j = value; j < k+1; j++) {
                dp[j] = Math.min(dp[j - value] + 1, dp[j]);
            }
        }
        if(dp[k]==999999){
            System.out.println("-1");
        }
        else {
            System.out.println(dp[k ]);
        }

    }
}
