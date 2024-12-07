import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int Macro(String st) {
        return Integer.parseInt(st);
    }

    static boolean[] isVisit;
    static  int N, M, start;
    static int[][] node;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Macro(st.nextToken());
        M = Macro(st.nextToken());
        start = Macro(st.nextToken());
        isVisit = new boolean[N + 1];
        node = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Macro(st.nextToken());
            int b = Macro(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }
        dfs(start);
        sb.append("\n");
        isVisit = new boolean[N + 1];
        bfs(start);

        System.out.println(sb);
    }

    static void dfs(int index) {
        isVisit[index] = true;
        sb.append(index).append(" ");
        for (int i = 0; i < N + 1; i++) {
            if (node[index][i] == 1 && !isVisit[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        isVisit[index] = true;
        while (!queue.isEmpty()) {
            index = queue.poll();
            sb.append(index).append(" ");
            for (int i = 1; i < N + 1; i++) {
                if (node[index][i] == 1 && !isVisit[i]) {
                    queue.offer(i);
                    isVisit[i] = true;
                }
            }
        }


    }


}
