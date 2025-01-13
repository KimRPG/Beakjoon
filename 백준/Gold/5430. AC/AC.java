import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char[] commands = br.readLine().toCharArray();
            br.readLine();
            Deque<Integer> deque = read(br.readLine());

            boolean reverse = false;
            boolean error = false;

            for (char command : commands) {
                if (command == 'R') {
                    reverse = !reverse;
                } else if (command == 'D') {
                    if (deque.isEmpty()) {
                        error = true;
                        sb.append("error\n");
                        break;
                    }
                    if (reverse) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            if (!error) {
                sb.append(formatOutput(deque, reverse)).append("\n");
            }
        }

        System.out.print(sb);
    }

    public static Deque<Integer> read(String string) {
        Deque<Integer> deque = new LinkedList<>();
        string = string.replace("[", "").replace("]", "");
        if (!string.isEmpty()) {
            String[] split = string.split(",");
            for (String ch : split) {
                deque.add(Integer.parseInt(ch));
            }
        }
        return deque;
    }

    public static String formatOutput(Deque<Integer> deque, boolean reverse) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Integer> iter = reverse ? deque.descendingIterator() : deque.iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext()) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}
