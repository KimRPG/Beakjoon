import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int a) {
        if (M == a) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        else {
            for (int i = 0; i < N; i++) {
                arr[a] = i + 1;
                dfs(a + 1);
            }
        }

    }
}
