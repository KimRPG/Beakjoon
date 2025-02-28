import jdk.dynalink.beans.StaticClass;

import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.sec == o2.sec) {
                return o1.num - o2.num;
            }
            return o1.sec - o2.sec;
        });
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                graph[i][j] = a;
                if (a != 0) {
                    queue.add(new Node(i, j, 0, a));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()) - 1;
        int Y = Integer.parseInt(st.nextToken()) - 1;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int sec = node.sec;
            int num = node.num;
            if(sec >= S) continue;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nSec = sec + 1;
                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(graph[nx][ny] !=0) continue;
                queue.add(new Node(nx, ny, nSec, num));
                graph[nx][ny] = num;
            }
        }

        System.out.println(graph[X][Y]);
    }

    public static class Node {
        int x;
        int y;
        int sec;
        int num;

        public Node(int x, int y, int sec, int num) {
            this.x = x;
            this.y = y;
            this.sec = sec;
            this.num = num;
        }
    }
}