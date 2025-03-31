import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] graph;
    public static boolean[][][] visit;
    public static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        visit = new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = chars[j] - '0';
            }
        }
        System.out.println(bfs()+1);
    }

    public static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, K, 0});
        visit[0][0][K] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curK = cur[2];
            int time = cur[3];
            if (curX == N - 1 && curY == M - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visit[nx][ny][curK]) continue;
                if (curK > 0 && !visit[nx][ny][curK - 1] && graph[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny, curK - 1, time + 1});
                    visit[nx][ny][curK - 1] = true;
                }
                if (graph[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny, curK, time + 1});
                    visit[nx][ny][curK] = true;
                }
            }
        }
        return -2;
    }
}
