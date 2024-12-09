import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int N;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            graph[row][col] = graph[col][row] = 1;
        }
        set = new HashSet<>();
        dfs(1);
        System.out.println(set.size() - 1);
    }

    static void dfs(int index) {
        set.add(index);
        for (int i = 0; i < N + 1; i++) {
            if (graph[index][i] == 1 && set.contains(index)) {
                graph[index][i] =graph[i][index] = 0;
                dfs(i);
            }
        }
    }
}
