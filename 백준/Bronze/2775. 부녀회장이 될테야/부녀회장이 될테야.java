import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] ans = new int[15][15];
        for (int i = 0; i < 15; i++) {
            ans[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                if (ans[i][j] == 0) {
                    int a = 0;
                    for (int k = 0; k < j; k++) {
                        a += ans[i - 1][k+1];
                    }
                    ans[i][j] = a;
                }
            }
        }


        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            sb.append(ans[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}
