import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Hi> pq = new PriorityQueue<>((a, b) -> {
            if (a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new Hi(x, y));
        }

        while (!pq.isEmpty()) {
            Hi hi = pq.poll();
            System.out.println(hi.x + " " + hi.y);
        }
    }

    // Hi 클래스 정의
    static class Hi {
        public int x;
        public int y;

        // 생성자
        public Hi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
