import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                int a = Integer.parseInt(st.nextToken());
                queue.add(a);
            }
            if (command.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(queue.poll()).append("\n");
                }
            }
            if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            if (command.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            if (command.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(queue.peek()).append("\n");
                }
            }
            if (command.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                }else {
                    sb.append(queue.peekLast()).append("\n");
                }
            }
        }

        System.out.println(sb);
        }

    }
