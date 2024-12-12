import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int a;
            if (pq.size() >= 2) {
                a = pq.poll() + pq.poll();
                ans += a;
                pq.add(a);
            }else {
                pq.poll();
            }
        }
        System.out.println(ans);

    }
}
