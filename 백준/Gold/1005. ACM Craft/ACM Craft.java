import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] time = new int[N];
            int[] dp = new int[N];
            int[] inDegree = new int[N];
            ArrayList<Integer>[] arr = new ArrayList[N];
            Queue<Integer> queue = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                arr[j] = new ArrayList<>();
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
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


            int ans = Integer.parseInt(br.readLine());
            sb.append(dp[ans - 1]).append("\n");
        }
        System.out.println(sb);

    }
}

