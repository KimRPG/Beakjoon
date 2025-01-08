import java.io.*;
import java.util.*;

public class Main {

    public static boolean[] visit;
    public static int[] graph;
    public static void main(String[] args) throws Exception {
        visit = new boolean[101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a] = b;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a] = b;
        }

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(1, 0);
        queue.add(node);
        visit[1] = true;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int position = n.nextPosition;
            int ans = n.ans;

            if (position == 100) return ans;

            for (int i = 1; i <= 6; i++) {
                int nextPosition = position + i;

                if(nextPosition>100) continue;
                if (graph[nextPosition] != 0) {
                    nextPosition = graph[nextPosition];
                }

                if (!visit[nextPosition]) {
                    visit[nextPosition] = true;
                    queue.add(new Node(nextPosition, ans + 1));
                }
            }
        }

        return -1;
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
