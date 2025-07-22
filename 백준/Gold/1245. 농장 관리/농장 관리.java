import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0, -1, 1, 1, -1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static int N, M;
    static int[][] graph;
    static boolean[][] visit;

    static int ans = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visit = new boolean[N][M];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[2] - o1[2]);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                if (a==0) visit[i][j] = true;
                pq.add(new int[]{i, j, a});
            }
        }
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            if (!visit[a[0]][a[1]]) {
                BFS(a[0], a[1]);
            }

        }
        System.out.println(ans);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (graph[now[0]][now[1]] < graph[nx][ny]) continue;


                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }
        ans++;

    }
}

