import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            HashMap<String,Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                String[] st = br.readLine().split(" ");
                map.put(st[1], map.getOrDefault(st[1], 1) + 1);
            }
            int ans = 1;
            for (Integer val : map.values()) {
                ans *= val;
            }
            sb.append(ans - 1).append("\n");
        }
        System.out.println(sb);

    }
}
