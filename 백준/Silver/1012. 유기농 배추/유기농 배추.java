import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int Macro(String st) {
        return Integer.parseInt(st);
    }

    static int[][] D = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] field;
    static int M, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Macro(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Macro(st.nextToken());
            N = Macro(st.nextToken());
            int K = Macro(st.nextToken());
            field = new int[M][N];
            int ans = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());
                field[row][col] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (field[j][k] == 1) {
                        dfs(j, k);
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");


        }
        System.out.println(sb);

    }

    static void dfs(int x, int y) {
        field[x][y] = 0;
        for (int[] dir : D) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < M && ny < N && field[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

}
