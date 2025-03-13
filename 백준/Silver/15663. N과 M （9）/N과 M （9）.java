import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] ans;
    static boolean[] visit;
    static Set<String> set = new LinkedHashSet<>();

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

        for (String str : set) {
            System.out.println(str);
        }
    }

    public static void dfs(int level) {
        if (level == M) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < M; i++) {
                str.append(ans[i]).append(" ");
            }
            set.add(str.toString());
        }else {
            for (int i = 0; i < N; i++) {
                if (!visit[i]) {
                    ans[level] = arr[i];
                    visit[i] = true;
                    dfs(level + 1);
                    visit[i] = false;
                }
            }
        }
    }

}
