import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M, max;

    static int[][] graph;
    static int[][] copyGraph;
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        copyGraph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                if (a == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        dfs(0, 0, new int[3][2]);
        System.out.println(max);
    }

    public static void dfs(int depth, int seq,int[][] canWall) {
        if (depth == 3) {
            for (int i = 0; i < N; i++) {
                copyGraph[i] = graph[i].clone();
            }
            for (int i = 0; i < 3; i++) {
                int[] wall = canWall[i];
                copyGraph[wall[0]][wall[1]] = 1;
            }
            bfs();

            return;
        }
        for (int i = seq; i < list.size(); i++) {
            canWall[depth] = list.get(i);
            dfs(depth + 1, i + 1, canWall);
        }
    }

    public static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(copyGraph[nx][ny] !=0) continue;

                queue.add(new int[]{nx, ny});
                copyGraph[nx][ny] = 2;
            }
        }
        max = Math.max(remain(), max);
    }

    public static int remain() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyGraph[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}