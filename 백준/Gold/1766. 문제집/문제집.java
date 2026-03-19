import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<List<Integer>> relate = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            relate.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            relate.get(start).add(end);
            arr[end]++;
        }
        for (int i = 0; i < N; i++) {
            if(arr[i] == 0) pq.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int start = pq.poll();
            sb.append(start + 1).append(" ");

            List<Integer> list = relate.get(start);
            for (int next : list) {
                arr[next]--;
                if (arr[next] == 0) {
                    pq.add(next);
                }
            }
        }
        System.out.println(sb);
    }
}