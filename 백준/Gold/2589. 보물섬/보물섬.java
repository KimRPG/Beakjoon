import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] graph;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                //L = 1, W = 0
                int a = chars[j] == 'L' ? 1 : 0;
                graph[i][j] = a;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 1) {
                    bfs(new Point(i, j, 0));
                }
            }
        }

        System.out.println(ans);
    }

    public static void bfs(Point point) {
        Queue<Point> queue = new ArrayDeque<>();
        visit = new boolean[N][M];
        visit[point.x][point.y] = true;
        queue.add(point);
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            ans = Math.max(ans, cur.cnt);
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;
                if(visit[nx][ny]) continue;
                if(graph[nx][ny] == 0) continue;
                queue.add(new Point(nx, ny, cur.cnt + 1));
                visit[nx][ny] = true;
            }
        }
    }

    public static class Point{
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

    }
}
