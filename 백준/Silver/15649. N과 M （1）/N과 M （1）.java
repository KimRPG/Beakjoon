import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N];
        arr = new int[N];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int a) {
        if (a == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]+1).append(" ");
            }
            sb.append("\n");
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                arr[a] = i;
                visit[i] = true;
                dfs(a + 1);
                visit[i] = false;
            }

        }
    }
}
