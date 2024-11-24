import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st1.nextToken());
        int p = Integer.parseInt(st1.nextToken());
        int t = 0;
        while (st.hasMoreTokens()) {
            int size = Integer.parseInt(st.nextToken());
            while (size  > 0) {
                t++;
                size -= a;
            }
        }
        System.out.println(t);
        System.out.println(sb.append(N / p).append(" ").append(N % p));

    }

}