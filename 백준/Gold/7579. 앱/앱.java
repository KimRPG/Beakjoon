import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<App> arrayList = new ArrayList<>();
        int[][] apps = new int[N][2];
        int[] dp = new int[M];
        Arrays.fill(dp,100_000_000);
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                apps[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            arrayList.add(new App(apps[i][0], apps[i][1]));
        }

        for (int i = 0; i < N; i++) {
            App app = arrayList.get(i);
            int mem = app.mem;
            int time = app.time;
            for (int j = M - 1; j >= 0; j--) {
                if (j < mem) {
                    dp[j] = Math.min(dp[j], time);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - mem] + time);

                }
            }
        }
        System.out.println(dp[M - 1]);

    }
    public static class App{
        int mem;
        int time;

        public App(int mem, int time) {
            this.mem = mem;
            this.time = time;
        }
    }
}
