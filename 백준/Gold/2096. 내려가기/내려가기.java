import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        int N = read();
        int[][] maxDP = new int[N][3];
        int[][] minDP = new int[N][3];
        int a = read();
        int b = read();
        int c = read();
        maxDP[0][0] = a;
        minDP[0][0] = a;
        maxDP[0][1] = b;
        minDP[0][1] = b;
        maxDP[0][2] = c;
        minDP[0][2] = c;
        for (int i = 1; i < N; i++) {
            a = read();
            b = read();
            c = read();
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    maxDP[i][j] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + a;
                    minDP[i][j] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + a;
                } else if (j == 1) {
                    maxDP[i][j] = Math.max(maxDP[i - 1][0], Math.max(maxDP[i - 1][1], maxDP[i - 1][2])) + b;
                    minDP[i][j] = Math.min(minDP[i - 1][0], Math.min(minDP[i - 1][1], minDP[i - 1][2])) + b;
                }else{
                    maxDP[i][j] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + c;
                    minDP[i][j] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + c;
                }
            }
        }
        System.out.print(Math.max(Math.max(maxDP[N-1][0],maxDP[N-1][1]),maxDP[N-1][2]));
        System.out.print(" ");
        System.out.println(Math.min(Math.min(minDP[N-1][0],minDP[N-1][1]),minDP[N-1][2]));
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3 ) + (n << 1) + (c & 15);
        return n;
    }
}