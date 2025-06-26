import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            treeMap.put(Integer.parseInt(st.nextToken()), 0);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            treeMap.remove(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(treeMap.size()).append("\n");
        for (int key : treeMap.keySet()) {
            sb.append(key).append(" ");
        }
        System.out.println(sb);
    }

}