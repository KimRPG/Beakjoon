import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int S =0, W = 0,X, Y;
    static int[][] graph;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        X = Integer.parseInt(st[0]);
        Y = Integer.parseInt(st[1]);
        graph = new int[X][Y];
        visit = new boolean[X][Y];
        for (int i = 0; i < X; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < Y; j++) {
                if (ch[j] == '#') {
                    graph[i][j] = 1;
                } else if (ch[j] == '.') {
                    graph[i][j] = 0;
                } else if (ch[j] == 'o') {
                    graph[i][j] = 2; //sheep
                } else if (ch[j] == 'v') {
                    graph[i][j] = 3; //wolf
                }
            }
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                }
            }
        }

        sb.append(S).append(" ").append(W);
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new ArrayDeque<>();
        int sheep = 0;
        int wolf = 0;
        queue.add(new int[]{x, y});
        visit[x][y] = true;
        while (!queue.isEmpty()) {

            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if(nx>=X || nx<0 || ny>=Y || ny<0) continue;
                if(graph[nx][ny] == 1) continue;
                if(visit[nx][ny]) continue;

                if(graph[nx][ny] == 2) sheep++;
                else if(graph[nx][ny] == 3) wolf++;

                queue.add(new int[]{nx, ny});
                visit[nx][ny] = true;
            }
        }

        if (sheep > wolf) {
            S += sheep;
        }else{
            W += wolf;
        }
    }
}

