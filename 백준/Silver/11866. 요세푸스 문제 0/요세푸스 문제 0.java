import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            q.add(i);
        }
        int a = 1;
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                sb.append(q.poll());
                break;
            }
            if (a % K == 0) {
                sb.append(q.poll()).append(", ");
            }else{
                q.add(q.poll());
            }
            a++;
        }
        sb.append(">");
        System.out.println(sb);

    }
}