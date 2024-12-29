import java.io.*;
import java.util.*;

public class Main {
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        int[] answer = new int[N + 1];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if(i == j) continue;
                graph[i][j] = 1000000000;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }
        floyd(N);
        int min=1000000000;
        for (int i = 1; i <= N; i++) {
            int ans=0;
            for (int j = 1; j <= N; j++) {
                ans += graph[i][j];
            }
            answer[i] = ans;
            min = Math.min(min, ans);
        }

        for (int i = 1; i <= N; i++) {
            if(answer[i] == min) {
                System.out.println(i);
                break;
            }
        }
    }


    public static void floyd(int n) {
        // 경유지
        for (int k = 1; k <= n; k++) {
            // 출발지
            for (int i = 1; i <= n; i++) {
                //도착지
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                }
            }
        }
    }
}
