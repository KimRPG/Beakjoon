import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];
        System.out.println(bfs(N));
    }

    public static int bfs(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int pos = cur[0];
            int time = cur[1];

            if (visited[pos]) continue;
            visited[pos] = true;

            if (pos == K) return time;

            if (pos * 2 <= 100_000) pq.add(new int[]{pos * 2, time});     
            if (pos - 1 >= 0) pq.add(new int[]{pos - 1, time + 1});       
            if (pos + 1 <= 100_000) pq.add(new int[]{pos + 1, time + 1});  
        }

        return -1;
    }
}
