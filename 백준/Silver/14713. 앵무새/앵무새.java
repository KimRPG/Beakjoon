import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Queue<String>> parrots = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            Queue<String> q = new ArrayDeque<>(Arrays.asList(br.readLine().split(" ")));
            parrots.add(q);
        }


        String[] sentence = br.readLine().split(" ");

        for (String word : sentence) {
            boolean matched = false;
            for (Queue<String> q : parrots) {
                if (!q.isEmpty() && q.peek().equals(word)) {
                    q.poll(); 
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                System.out.println("Impossible");
                return;
            }
        }

        for (Queue<String> q : parrots) {
            if (!q.isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }

        System.out.println("Possible");
    }
}
