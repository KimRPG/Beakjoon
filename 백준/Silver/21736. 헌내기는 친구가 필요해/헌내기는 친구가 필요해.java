import java.io.*;
import java.util.*;

public class Main {

    public static boolean[][] visit;
    public static char[][] graph;
    static int N, M;
    static int ans;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int x = 0, y = 0;
        ans = 0;
        visit = new boolean[N][M];
        graph = new char[N][M];
        for (int i = 0; i < N; i++) {
            char[] hi = br.readLine().toCharArray();
            graph[i] = hi;
            for (int j = 0; j < hi.length; j++) {
                if (graph[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }
        dfs(x, y);
        
        if(ans == 0 ) System.out.println("TT");
        else System.out.println(ans);
        
    }

    public static void dfs(int x, int y) {
        visit[x][y] = true;
        if(graph[x][y] == 'P') ans++;
        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(visit[nx][ny] || graph[nx][ny] == 'X') continue;
            

            dfs(nx, ny);
        }
    } 
    
    public static class Node {
        int nextPosition;
        int ans;

        public Node(int nextPosition, int ans) {
            this.nextPosition = nextPosition;
            this.ans = ans;
        }
    }
}
