import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int limit = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[K];
        int[][] graph = new int[K+1][limit + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(value, time);
        }

        for (int i = 1; i <= K; i++) {
            Node node = nodes[i - 1];
            int value = node.value;
            int time = node.time;
            for (int j = 0; j <= limit; j++) {
                if (time <= j) {
                    graph[i][j] = Math.max(graph[i - 1][j], graph[i-1][j - time] + value);
                }
                else{
                    graph[i][j] = graph[i - 1][j];
                }
            }
        }

        System.out.println(graph[K][limit]);

    }

    public static class Node{
        int value;
        int time;

        public Node(int value, int time) {
            this.value = value;
            this.time = time;
        }
    }
}
