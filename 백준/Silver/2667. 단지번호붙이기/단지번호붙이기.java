import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visit;
    static int[][] graph;
    static int N, cnt;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            char[] hi = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                graph[i][j] = hi[j] - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && graph[i][j] ==1) {
                    dfs(i, j);
                    list.add(cnt);
                    cnt = 1;
                }
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (visit[nx][ny] || graph[nx][ny] == 0) continue;
            cnt++;
            dfs(nx, ny);

        }
    }

}
