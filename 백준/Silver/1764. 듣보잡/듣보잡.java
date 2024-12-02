import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> hashMap = new HashSet<>();
        List<String> pq = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            hashMap.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String hi = br.readLine();
            if (hashMap.contains(hi)) {
                pq.add(hi);
            }
        }
        sb.append(pq.size()).append("\n");
        pq.sort(Comparator.naturalOrder());
        for (String a : pq) {
            sb.append(a).append("\n");
        }
        System.out.println(sb);
    }
}

