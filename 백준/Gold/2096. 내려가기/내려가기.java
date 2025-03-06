import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] maxDP = new int[N][3];
        int[][] minDP = new int[N][3];
        int a = Integer.parseInt(st.nextToken());
        int b= Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        maxDP[0][0] = a;
        minDP[0][0] = a;
        maxDP[0][1] = b;
        minDP[0][1] = b;
        maxDP[0][2] = c;
        minDP[0][2] = c;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b= Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
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
}