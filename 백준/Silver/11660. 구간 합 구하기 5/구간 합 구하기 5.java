import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += Integer.parseInt(st.nextToken());
                graph[i][j] = sum;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ans = 0;
            for (int j = x1 - 1; j < x2; j++) {
                if (y1 - 2 < 0) {
                    ans += graph[j][y2 - 1];
                }else{
                    ans += (graph[j][y2 - 1] - graph[j][y1 - 2]);
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
