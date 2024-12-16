    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.PriorityQueue;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(br.readLine());
                if (a == 0 && pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else if (a == 0) {
                    sb.append(pq.poll()).append("\n");
                }else{
                    pq.add(a);
                }
            }
            System.out.println(sb);
        }
    }
