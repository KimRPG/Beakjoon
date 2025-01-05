import java.io.*;
import java.util.*;
public class Main {
    static int N, K, ans = 0;
    static boolean[] graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new boolean[100_001];
        System.out.println(bfs(N));
    }

    public static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        while (!queue.isEmpty()) {
            int[] array = queue.poll();
            int a = array[0];
            graph[a] = true;
            int day = array[1];
            if (a == K) {
                return day;
            }
            if (a - 1 >= 0 && !graph[a - 1]) {
                queue.add(new int[]{a - 1, day + 1});
                graph[a - 1] = true;
            }
            if (a + 1 <= 100000 && !graph[a + 1]) {
                queue.add(new int[]{a + 1, day + 1});
                graph[a + 1] = true;
            }
            if (a * 2 <= 100000 && !graph[a * 2]) {
                queue.add(new int[]{a * 2, day + 1});
                graph[a * 2] = true;
            }
        }
        return 0;
    }
}