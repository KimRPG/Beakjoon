import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};

    static int N, M, H;
    static int[][][] graph;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        graph = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        ans = 0;

        // 그래프 입력 및 초기화
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    int value = Integer.parseInt(st.nextToken());
                    graph[h][n][m] = value;
                    if (value == 1) {
                        queue.add(new int[]{h, n, m, 0}); // {높이, 행, 열, 날짜}
                    }
                }
            }
        }

        bfs(queue);

        // 익지 않은 토마토가 있는지 확인
        if (isFinish()) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curH = cur[0];
            int curN = cur[1];
            int curM = cur[2];
            int curDay = cur[3];

            for (int i = 0; i < 6; i++) {
                int distH = curH + dh[i];
                int distN = curN + dy[i];
                int distM = curM + dx[i];

                // 범위 확인
                if (distH < 0 || distH >= H || distN < 0 || distN >= N || distM < 0 || distM >= M) continue;
                if (graph[distH][distN][distM] != 0) continue;

                // 토마토 익히기
                graph[distH][distN][distM] = 1;
                queue.add(new int[]{distH, distN, distM, curDay + 1});
                ans = Math.max(ans, curDay + 1);
            }
        }
    }

    public static boolean isFinish() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (graph[h][n][m] == 0) return false;
                }
            }
        }
        return true;
    }
}
