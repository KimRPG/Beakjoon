import java.io.*;
import java.util.*;

public class Main {
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.node;
            int currentCost = current.cost;

            if (currentCost > dist[currentNode]) continue; // 이미 처리된 노드

            for (Node next : graph[currentNode]) {
                int newCost = dist[currentNode] + next.cost;

                if (newCost < dist[next.node]) {
                    dist[next.node] = newCost;
                    pq.add(new Node(next.node, newCost));
                }
            }
        }
    }

    static class Node {
        int node, cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
