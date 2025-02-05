import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] graph;
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line[j] - '0';
            }
        }
        System.out.println(bfs() + 1);

    }

    public static int bfs() {
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int day = cur[2];
            if (x == N - 1 && y == M - 1) {
                return day;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nDay = day + 1;
                if(nx<0 || nx>=N || ny<0 || ny>=M ) continue;
                if(graph[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;

                queue.add(new int[]{nx, ny, nDay});
                visit[nx][ny] = true;
            }
        }
        return ans;
    }



}
