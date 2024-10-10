package silver.p1059;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<");
//      q.isEmpty()
        while (q.size() != 1) {
            for (int i = 0; i < K - 1; i++) {
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
//        sb.setLength(sb.length()-2);
        sb.append(q.poll()).append(">");

        System.out.println(sb + "\n");
        br.close();
    }
}
