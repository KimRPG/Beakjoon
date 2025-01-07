import java.io.*;
import java.util.*;

public class Main {
    public static int[][] graph;
    public static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    static int N, M, r, c, d, ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(ans);
    }

    public static void clean(int x, int y, int dir) {
        if (graph[x][y] == 0) {
            graph[x][y] = 2;
            ans++;
        }

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;

            int nx = x + Main.dir[dir][0];
            int ny = y + Main.dir[dir][1];

            if (isInBounds(nx, ny) && graph[nx][ny] == 0) {
                clean(nx, ny, dir);
                return;
            }
        }

        int backDir = (dir + 2) % 4;
        int bx = x + Main.dir[backDir][0];
        int by = y + Main.dir[backDir][1];

        if (isInBounds(bx, by) && graph[bx][by] != 1) {
            clean(bx, by, dir);
        }
    }

    public static boolean isInBounds(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
