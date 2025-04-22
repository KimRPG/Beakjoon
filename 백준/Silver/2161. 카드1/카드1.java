import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }
        boolean flag = true;
        while (!queue.isEmpty()) {
            if (flag) {
                sb.append(queue.poll()).append(" ");
                flag = false;
            }else{
                queue.add(queue.poll());
                flag = true;
            }
        }
        System.out.println(sb);
    }

}
