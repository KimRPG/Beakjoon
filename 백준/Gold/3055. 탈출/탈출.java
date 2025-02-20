import java.io.*;
import java.util.*;
public class Main {
    static char[][] graph;
    static int endR, endC, startR, startC, R,C;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Node> queue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.turn == o2.turn) {
                return o1.ch - o2.ch;
            }
            return o1.turn - o2.turn;
        });
        for (int i = 0; i < R; i++) {
            char[] strings = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                char ch = strings[j];
                graph[i][j] = ch;
                if (ch == 'S') {
                    startR = i;
                    startC = j;
                    queue.add(new Node(i, j, 0, ch));
                } else if (ch == 'D') {
                    endR = i;
                    endC = j;
                } else if (ch == '*') {
                    queue.add(new Node(i, j, 0, ch));
                }
            }
        }

        int ans = bfs();
        if (ans == -1) {
            System.out.println("KAKTUS");
        }
        else{
            System.out.println(ans);
        }
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int turn = node.turn;
            char ch = node.ch;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                if (graph[nx][ny] == 'D' && ch == 'S') {
                    return turn + 1;
                }
                if (graph[nx][ny] != '.') continue;
                queue.add(new Node(nx, ny, turn + 1, ch));
                graph[nx][ny] = ch;
            }
        }
        return -1;
    }
    static class Node{
        int x;
        int y;
        int turn;
        char ch;


        public Node(int x, int y, int turn, char ch) {
            this.x = x;
            this.y = y;
            this.turn = turn;
            this.ch = ch;
        }

    }
}