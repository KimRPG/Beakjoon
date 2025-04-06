import java.io.*;
import java.util.*;

public class Main {
    static long N,M,P;
    static Map<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        map.put(0L, 1L);
        System.out.println(dp(N));

    }

    public static long dp(long key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }else {
            long a = key / M;
            long b = key / P;
            long result = dp(a) + dp(b);
            map.put(key, result);
            return result;
        }
    }
}
