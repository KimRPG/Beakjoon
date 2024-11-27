import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>((x,y)->{
            if (x.length() == y.length()) {
                return x.compareTo(y);
            }
            return x.length() - y.length();
        }
        );
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (!pq.contains(s)) {
                pq.add(s);
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
