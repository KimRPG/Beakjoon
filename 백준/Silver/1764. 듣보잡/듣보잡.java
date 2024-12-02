import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer ans = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            hashMap.put(br.readLine(), 1);
        }
        for (int i = 0; i < M; i++) {
            String hi = br.readLine();
            if (hashMap.containsKey(hi)) {
                pq.add(hi);
            }
        }
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}

