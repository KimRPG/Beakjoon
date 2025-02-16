import java.io.*;
import java.util.*;

public class Main {
    static int startX, startY, n,endX, endY;

    static int[][] graph;
    static boolean[] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            graph = new int[n + 1][2];
            visit = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[j] = new int[]{x, y};
            }
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());
            graph[n] = new int[]{endX, endY};
            sb.append(bfs()).append("\n");
        }

        System.out.println(sb);
    }

    public static int dist(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }

    public static String bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] pre = queue.poll();
            if (pre[0] == endX && pre[1] == endY) {
                return "happy";
            }
            for (int i = 0; i < n + 1; i++) {
                if (visit[i]) {
                    continue;
                }
                if (dist(pre, graph[i]) <= 1000) {
                    queue.add(graph[i]);
                    visit[i] = true;
                }
            }
        }
        return "sad";
    }
}
