import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a >= 0) {
                pq.add(a);
            }else{
                pq2.add(a);
            }
        }
        int ans = 0;
        boolean isZero = false;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            if (a == 0) {
                if (pq.isEmpty()) {
                    isZero = true;
                    continue;
                }
            }
            if (a == 1) {
                ans++;
            }
            if (a > 1) {
                if (pq.isEmpty()) {
                    ans += a;
                    break;
                }else {
                    int b = pq.poll();
                    if (b > 1) {
                        ans += a * b;
                    }
                    else{
                        ans += a;
                        pq.add(b);
                    }
                }
            }
        }

        while (!pq2.isEmpty()) {
            int a = pq2.poll();
            if (pq2.isEmpty()) {
                if (!isZero) {
                    ans += a;
                }
            }
            else{
                int b = pq2.poll();
                ans += a * b;
            }
        }
        System.out.println(ans);

    }
}
