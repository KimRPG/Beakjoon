import java.io.*;
import java.util.*;
public class Main {
    static char[][] ch = new char[8][8];
    static char[][] ch2 = new char[8][8];

    static char[][] ch3;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ch3 = new char[N][M];
        for (int i = 0; i < N; i++) {
            ch3[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    ch[i][j] = 'B';
                    ch2[i][j] = 'W';
                }else {
                    ch[i][j] = 'W';
                    ch2[i][j] = 'B';
                }
            }
        }
        int ans = 1_000_000;
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                ans = Math.min(ans, min(i, j));
            }
        }


        System.out.println(ans);
    }

    public static int min(int x, int y) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(ch[i][j] != ch3[x + i][y + j]) a++;
                if(ch2[i][j] != ch3[x + i][y + j]) b++;
            }
        }
        return Math.min(a, b);
    }

}