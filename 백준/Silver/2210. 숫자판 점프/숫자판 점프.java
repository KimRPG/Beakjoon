import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] graph = new int[5][5];
    static HashSet<String> set = new HashSet<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, "");
            }
        }
        System.out.println(set.size());

    }


    public static void dfs(int x, int y, String ans) {
        if (ans.length() == 6) {
            set.add(ans);
        }
        else{
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                String nAns = ans + graph[nx][ny];
                dfs(nx, ny, nAns);
            }
        }

    }
}
