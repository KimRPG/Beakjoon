import java.io.*;
import java.util.*;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    ans++;
                    dfs(i, j);
                }
            }
        }
        sb.append(ans).append(" ");
        visited = new boolean[N][N];

        int colorAns = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    colorAns++;
                    dfsColor(i, j);
                }
            }
        }
        sb.append(colorAns);
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        char rgb = graph[x][y];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if(rgb != graph[nx][ny]||visited[nx][ny]) continue;
            dfs(nx, ny);
        }
    }

    static void dfsColor(int x, int y) {
        visited[x][y] = true;
        char rgb = graph[x][y];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(nx<0||nx>=N||ny<0||ny>=N) continue;
            if (rgb == 'R' || rgb == 'G') {
                if(graph[nx][ny] == 'B'||visited[nx][ny]) continue;
            }else{
                if(rgb != graph[nx][ny]||visited[nx][ny]) continue;
            }
            dfsColor(nx, ny);
        }
    }
}
