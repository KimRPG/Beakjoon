import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int prime = (int) Math.pow(10, N);

        back(0, 2);
        back(0, 3);
        back(0, 5);
        back(0, 7);
        System.out.println(sb);
    }
    public static void back(int depth, int now) {
        if (depth == N - 1) {
            sb.append(now).append("\n");
            return;
        }
        {
            for (int i = 1; i < 10; i++) {
                int nNum = now * 10 + i;
                boolean prime = true;
                for (int j = 2; j <= Math.sqrt(nNum); j++) {
                    if (nNum % j == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    back(depth+1, nNum);
                }
            }
        }
    }
}

