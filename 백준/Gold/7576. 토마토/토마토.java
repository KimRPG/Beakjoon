import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] isVisit;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[M][N];
        isVisit = new boolean[M][N];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    isVisit[i][j] = true;
                }
            }
        }

        // BFS 실행
        int maxDays = bfs(queue);

        // 결과 출력
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(maxDays);
    }

    static int bfs(Queue<int[]> queue) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxDays = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int day = current[2];
            maxDays = Math.max(maxDays, day);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (isVisit[nx][ny] || graph[nx][ny] != 0) continue;

                queue.add(new int[]{nx, ny, day + 1});
                isVisit[nx][ny] = true;
                graph[nx][ny] = 1;
            }
        }

        return maxDays;
    }
}

