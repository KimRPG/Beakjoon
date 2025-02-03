import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                if (pq.isEmpty() && pq2.isEmpty()) {
                    sb.append(0).append("\n");
                } else if (!pq.isEmpty()) {
                    int b = pq.poll();
                    if(!pq2.isEmpty()){
                        int c = pq2.poll();
                        int d = Math.abs(c);
                        if (b < d) {
                            sb.append(b).append("\n");
                            pq2.add(c);
                        } else {
                            sb.append(c).append("\n");
                            pq.add(b);
                        }
                    }else{
                        sb.append(b).append("\n");
                    }
                }else{
                    sb.append(pq2.poll()).append("\n");
                }
            }

                else if (a > 0) {
                    pq.add(a);
                } else {
                    pq2.add(a);
                }
        }

            System.out.println(sb);
    }
}
