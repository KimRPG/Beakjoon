import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100]; // dp 크기 수정 (99 → 100)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] hp = new int[N];
        for (int i = 0; i < N; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] happy = new int[N];
        for (int i = 0; i < N; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int myHp = hp[i];
            for (int j = 99; j >= myHp; j--) { // 98 → 99, j >= myHp로 변경
                if (j - myHp < 100) { // 체력이 100 이상 되면 안 됨
                    dp[j] = Math.max(dp[j], dp[j - myHp] + happy[i]);
                }
            }
        }

        System.out.println(dp[99]); // dp[98] → dp[99] 출력
    }
}
