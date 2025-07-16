import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] times = new int[N];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            int time = read();
            times[i] = time;
            result[i] = time;
            int a = read();
            for (int j = 0; j < a; j++) {
                result[i] = Math.max(result[i], result[read()-1] + times[i]);
            }
        }
        int max = 0;
        for (int a : result) {
            max = Math.max(a, max);
        }

        System.out.println(max);
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return n;

    }
}
