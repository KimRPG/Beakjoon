import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        ArrayList<Node> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.add(new Node(w, v));
        }

        for (int i = 1; i <= N; i++) {
            Node node = arr.get(i - 1);
            for (int j = 0; j <= K; j++) {
                if (j >= node.weight) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - node.weight] + node.value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    static class Node {
        int weight, value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
