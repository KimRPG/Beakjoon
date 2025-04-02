import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.println(ans);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];  // 이미 계산된 값이 있으면 반환

        dp[x][y] = 1; // 현재 위치에서 시작하는 경우 최소 길이는 1

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (graph[x][y] >= graph[nx][ny]) continue; // 더 높은 곳으로만 이동 가능

            dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }

        return dp[x][y];
    }
}
