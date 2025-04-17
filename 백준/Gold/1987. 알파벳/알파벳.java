import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R, C, max = 0;

    static char[][] graph;
    static boolean[] visit = new boolean[26];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];

        for (int i = 0; i < R; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        visit[graph[0][0] - 'A'] = true;
        dfs(1, 0, 0);
        System.out.println(max);
    }

    public static void dfs(int turn, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
            if(visit[graph[nx][ny]-'A']) continue;
            visit[graph[nx][ny] - 'A'] = true;
            dfs(turn + 1, nx, ny);
            visit[graph[nx][ny] - 'A'] = false;
        }
        max = Math.max(turn, max);
    }

}