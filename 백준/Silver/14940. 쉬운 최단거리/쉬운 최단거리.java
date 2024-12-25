import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr= new int[N][M];

        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    arr[i][j] = 0;
                    x = i;
                    y = j;
                }

            }
        }
        visited = new boolean[N][M];
        BFS(x, y);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    arr[i][j] = -1;
                }
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);


    }
    public static void BFS(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (visited[nx][ny] || arr[nx][ny] == 0)
                    continue;
                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
                arr[nx][ny] = arr[n.x][n.y] + 1;
            }
        }
    }
}
class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}