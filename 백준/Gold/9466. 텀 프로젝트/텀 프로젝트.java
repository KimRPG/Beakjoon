import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static boolean[] done;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            cnt = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) dfs(i);
            }

            sb.append(n - cnt).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int next = arr[cur];

        if (!visited[next]) {
            dfs(next);
        } else if (!done[next]) {
            for (int i = next; i != cur; i = arr[i]) {
                cnt++;
            }
            cnt++;
        }

        done[cur] = true;
    }
}
