import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] arr, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        back(0, 0);
        System.out.println(sb);
    }

    public static void back(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            ans[depth] = arr[i];
            back(i + 1, depth + 1);
        }
    }
}