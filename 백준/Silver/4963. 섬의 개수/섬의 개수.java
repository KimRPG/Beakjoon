import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[][] graph;
    static boolean[][] visit;
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if(x+y == 0) break;

            graph = new int[y][x];
            visit = new boolean[y][x];
            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if(visit[i][j]) continue;
                    if(graph[i][j]==0) continue;
                    bfs(j, i);
                    ans++;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 8; i++) {
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];
                if (ny < 0 || ny >= Main.y || nx < 0 || nx >= Main.x) continue;
                if (visit[ny][nx]) continue;
                if (graph[ny][nx] == 0) continue;
                queue.add(new int[]{ny, nx});
                visit[ny][nx] = true;
            }
        }
    }

}