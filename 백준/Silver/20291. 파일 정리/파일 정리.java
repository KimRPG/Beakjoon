import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split("\\.");
            treeMap.put(st[1], treeMap.getOrDefault(st[1], 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }
        System.out.println(sb);
    }

}