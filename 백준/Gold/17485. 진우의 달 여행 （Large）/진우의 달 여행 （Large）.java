import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int N = read();
        int M = read();

        int[][] arr = new int[N][M];
        int[][] prev = new int[M][3];
        int[][] curr = new int[M][3];

        // 첫 줄 입력 및 초기화
        for (int i = 0; i < M; i++) {
            arr[0][i] = read();
            prev[i][0] = arr[0][i];
            prev[i][1] = arr[0][i];
            prev[i][2] = arr[0][i];
        }

        // 나머지 줄 입력
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = read();
            }

            for (int j = 0; j < M; j++) {
                int left = j - 1;
                int right = j + 1;
                int val = arr[i][j];

                curr[j][0] = (left < 0) ? 100_000_000 : Math.min(prev[left][1], prev[left][2]) + val;
                curr[j][1] = Math.min(prev[j][0], prev[j][2]) + val;
                curr[j][2] = (right >= M) ? 100_000_000 : Math.min(prev[right][0], prev[right][1]) + val;
            }

            // swap
            int[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        int min = 100_000_000;
        for (int i = 0; i < M; i++) {
            for (int d = 0; d < 3; d++) {
                min = Math.min(min, prev[i][d]);
            }
        }

        sb.append(min);
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
