import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] graph;
    static boolean[][] isVisit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int maxAns = 0;
        int max = 0;
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                max = Math.max(a, max);
            }
        }

        for (int i = 0; i < max; i++) {
            int ans = 0;
            isVisit = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!isVisit[j][k] && graph[j][k] > i) {
                        ans++;
                        BFS(j, k, i);
                    }
                }
            }
            maxAns = Math.max(maxAns, ans);
        }

        System.out.println(maxAns);
    }

    public static void BFS(int x, int y,int water) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(isVisit[nx][ny]) continue;
                if(graph[nx][ny] <= water) continue;
                queue.add(new int[]{nx, ny});
                isVisit[nx][ny] = true;
            }
        }
    }
}