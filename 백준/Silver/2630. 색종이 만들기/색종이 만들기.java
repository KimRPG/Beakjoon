import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int white, blue;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    static void divide(int x, int y, int N) {
        int color = paper[x][y];
        boolean isSame = true;
        for (int i = x; i < x+N; i++) {
            for (int j = y; j < y+N; j++) {
                if (color != paper[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame) break;
        }

        if (isSame) {
            if (color == 0) {
                white++;
            }
            if (color == 1) {
                blue++;
            }
        } else {
            divide(x, y, N / 2);
            divide(x, y + N / 2, N / 2);
            divide(x+ N / 2, y, N / 2);
            divide(x+ N / 2, y + N / 2, N / 2);
        }
    }
}