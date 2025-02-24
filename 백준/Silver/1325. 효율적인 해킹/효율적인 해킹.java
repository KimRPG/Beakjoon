import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static HashSet<Integer> set;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] ans = new int[N + 1];
        set = new HashSet<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
        }
        int max = 0;
        for (int i = 1; i < N+1; i++) {
            set = new HashSet<>();
            visit = new boolean[N + 1];
            dfs(i);
            max = Math.max(set.size(), max);
            ans[i] = set.size();
        }
        for (int i = 1; i < N+1; i++) {
            if (max == ans[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    public static void dfs(int index) {
        set.add(index);
        visit[index] = true;
        for (int next : graph.get(index)) {
            if (!visit[next]) {
                dfs(next);
            }
        }
    }
}
