import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = read();
        for (int i = 0; i < T; i++) {
            int N = read();
            int K = read();
            int[] time = new int[N];
            int[] dp = new int[N];
            int[] inDegree = new int[N];
            ArrayList<Integer>[] arr = new ArrayList[N];
            Queue<Integer> queue = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                arr[j] = new ArrayList<>();
            }
            for (int j = 0; j < N; j++) {
                time[j] = read();
            }
            for (int j = 0; j < K; j++) {
                int x = read() - 1;
                int y = read() - 1;
                inDegree[y]++;
                arr[x].add(y);
            }
            for (int j = 0; j < N; j++) {
                if(inDegree[j]==0) queue.add(j);
            }
            while (!queue.isEmpty()) {
                int start = queue.poll();
                dp[start] += time[start];
                for (int next : arr[start]) {
                    dp[next] = Math.max(dp[start], dp[next]);
                    inDegree[next]--;
                    if(inDegree[next] == 0) queue.add(next);
                }
            }


            int ans = read();
            sb.append(dp[ans - 1]).append("\n");
        }
        System.out.println(sb);

    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return n;

    }
}

