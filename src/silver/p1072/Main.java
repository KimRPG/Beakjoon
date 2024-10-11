package silver.p1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int Macro(String st) {
        return Integer.parseInt(st);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Macro(st.nextToken());
        long y = Macro(st.nextToken());
        int ans = -1;
        int z = (int) (y * 100 / x);

        if (z < 99) {
            ans = (int) Math.ceil((x * (z + 1) - 100 * y) / (double) (99 - z));
        }

        System.out.println(ans);
    }
}
