import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            if (n == 1) {
                int ans = Math.max(arr[n - 1][0], arr[n - 1][1]);
                sb.append(ans).append("\n");
                continue;
            }
            arr[1][0] += arr[0][1];
            arr[1][1] += arr[0][0];

            for (int j = 2; j < n; j++) {
                arr[j][0] = Math.max(Math.max(arr[j - 1][1] + arr[j][0], arr[j - 2][0] + arr[j][0]), arr[j - 2][1] + arr[j][0]);
                arr[j][1] = Math.max(Math.max(arr[j - 1][0] + arr[j][1], arr[j - 2][0] + arr[j][1]), arr[j - 2][1] + arr[j][1]);
            }
            int ans = Math.max(arr[n - 1][0], arr[n - 1][1]);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
    
}

