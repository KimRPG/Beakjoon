import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][][] visit;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visit = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                graph[i][j] = arr[j] - '0';
            }
        }
        System.out.println(bfs());




    }
    public static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, true, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            boolean wall = node.wall;
            int day = node.day;

            if(x == N-1 && y == M-1 ){
                return day + 1;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nDay = day + 1;
                int nWall = wall ? 1 : 0;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (graph[nx][ny] == 1 && wall) {
                    if(!visit[nx][ny][0]){
                        visit[nx][ny][0] = true;
                        queue.add(new Node(nx, ny, false, nDay));
                    }
                }
                else if (graph[nx][ny] == 0) {
                    if (!visit[nx][ny][nWall]) {
                        visit[nx][ny][nWall] = true;
                        queue.add(new Node(nx, ny, wall, nDay));
                    }
                }

            }

        }
        return -1;
    }

    public static class Node {
        int x;
        int y;
        boolean wall;
        int day;

        public Node(int x, int y, boolean wall, int day) {
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.day = day;
        }
    }
}
