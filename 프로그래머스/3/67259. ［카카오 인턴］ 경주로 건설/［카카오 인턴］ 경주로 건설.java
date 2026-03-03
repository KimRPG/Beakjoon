import java.util.*;

class Solution {
    private static final int[] dy = {-1, 1, 0, 0};
    private static final int[] dx = {0, 0, -1, 1};
    private static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int y, x, dir, cost;

        Node(int y, int x, int dir, int cost) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] dist = new int[n][n][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        if (board[0][1] == 0) {
            dist[0][1][3] = 100;
            pq.add(new Node(0, 1, 3, 100));
        }
        if (board[1][0] == 0) {
            dist[1][0][1] = 100;
            pq.add(new Node(1, 0, 1, 100));
        }

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.y][current.x][current.dir] < current.cost) continue;

            for (int i = 0; i < 4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];

                if (ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 0) {
    
                    int nextCost = current.cost + (current.dir == i ? 100 : 600);

                    if (nextCost < dist[ny][nx][i]) {
                        dist[ny][nx][i] = nextCost;
                        pq.add(new Node(ny, nx, i, nextCost));
                    }
                }
            }
        }
        int answer = INF;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dist[n - 1][n - 1][i]);
        }

        return answer;
    }
}