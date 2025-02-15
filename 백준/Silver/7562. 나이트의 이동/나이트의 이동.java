import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static boolean[][] visit;
    static int[][] graph;
    static int I;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            I = Integer.parseInt(br.readLine());
            visit = new boolean[I][I];
            graph = new int[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            sb.append(bfs(new int[]{startX, startY,0}, new int[]{endX, endY})).append("\n");
        }
        System.out.println(sb);
    }

    public static int bfs(int[] start, int[] end) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visit[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            int ans = point[2];
            if (x == end[0] && y == end[1]) {
                return ans;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nAns = ans + 1;
                if(nx <0 || nx >= I || ny<0 || ny>=I) continue;
                if(visit[nx][ny]) continue;

                queue.add(new int[]{nx, ny, nAns});
                visit[nx][ny] = true;
            }
        }
        return -1;
    }
}
