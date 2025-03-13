import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] ans;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int level) {
        if (level == M) {
            for (int i = 0; i < M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
        }else {
            for (int i = 0; i < N; i++) {
                if(visit[i]) continue;
                if (i >= 1 && arr[i] == arr[i - 1] && !visit[i-1]) {
//                    System.out.println("arr[i] = " + arr[i] + "arr[i-1] =" + arr[i - 1]);
                    continue;
                }
                ans[level] = arr[i];
                visit[i] = true;
                dfs(level + 1);
                visit[i] = false;

            }
        }
    }

}
