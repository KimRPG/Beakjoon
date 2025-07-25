import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;
    static boolean[][] visit;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int max = 0;
        int ans = 0;
        graph = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                if(graph[i][j] ==0) continue;
                ans = Math.max(BFS(i, j), ans);
                max++;

            }
        }
        System.out.println(max);
        System.out.println(ans);

    }

    public static int BFS(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 1});
        visit[x][y] = true;
        int max = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            max = Math.max(max, node[2]);
            for (int i = 0; i < 4; i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if(visit[nx][ny]) continue;
                if(graph[nx][ny] == 0) continue;
                queue.add(new int[]{nx, ny, node[2] + 1 + queue.size()});
                visit[nx][ny] = true;
            }
        }

        return max;
    }
}
