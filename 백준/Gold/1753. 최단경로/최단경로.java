import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(br.readLine()) - 1;

        // 인접 리스트 생성
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        // 거리 배열 초기화
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;

        // 다익스트라 실행
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(startNode, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.node;
            int currentCost = node.cost;

            if (dist[current] < currentCost) continue; // 이미 처리된 노드

            for (Node next : graph.get(current)) {
                int newCost = currentCost + next.cost;
                if (newCost < dist[next.node]) {
                    dist[next.node] = newCost;
                    pq.add(new Node(next.node, newCost));
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static class Node {
        int node;
        int cost;

        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
}
