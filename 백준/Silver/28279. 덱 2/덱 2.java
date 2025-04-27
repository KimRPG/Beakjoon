import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()) { // case 1과 2는 값을 하나 더 읽어야 하므로 확인
                int value = Integer.parseInt(st.nextToken());
                switch (com) {
                    case 1:
                        deque.addFirst(value);
                        break;
                    case 2:
                        deque.addLast(value);
                        break;
                }
            } else {
                switch (com) {
                    case 3:
                        if (deque.isEmpty()) {
                            sb.append("-1").append("\n");
                        } else {
                            sb.append(deque.pollFirst()).append("\n");
                        }
                        break;
                    case 4:
                        if (deque.isEmpty()) {
                            sb.append("-1").append("\n");
                        } else {
                            sb.append(deque.pollLast()).append("\n");
                        }
                        break;
                    case 5:
                        sb.append(deque.size()).append("\n");
                        break;
                    case 6:
                        if (deque.isEmpty()) {
                            sb.append("1").append("\n");
                        } else {
                            sb.append("0").append("\n");
                        }
                        break;
                    case 7:
                        if (deque.isEmpty()) {
                            sb.append("-1").append("\n");
                        } else {
                            sb.append(deque.peekFirst()).append("\n");
                        }
                        break;
                    case 8:
                        if (deque.isEmpty()) {
                            sb.append("-1").append("\n");
                        } else {
                            sb.append(deque.peekLast()).append("\n");
                        }
                        break;
                }
            }
        }
        System.out.println(sb);
    }
}