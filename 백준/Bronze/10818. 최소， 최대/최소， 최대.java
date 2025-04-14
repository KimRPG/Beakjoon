import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int max = -1_000_001;
        int min = 1_000_001;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int a = read();
            max = Math.max(max, a);
            min = Math.min(min, a);
        }
        sb.append(min).append(" ").append(max);
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c = System.in.read();
        int n = 0;
        boolean negative = false;

        // 음수 처리
        if (c == '-') {
            negative = true;
            c = System.in.read();
        }

        n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return negative ? -n : n;
    }
}
