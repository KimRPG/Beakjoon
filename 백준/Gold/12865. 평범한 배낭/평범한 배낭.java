import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Node> arr = new ArrayList<>();
        dp = new int[N+1][K+1];
        for (int i = 1; i < N+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.add(new Node(w, v));
        }
        for (int i = 1; i < N+1; i++) {
            Node node = arr.get(i-1);
            for (int j = 0; j < K+1; j++) {
                if (dp[i][j] == -1 && node.weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - node.weight] + node.value);
                } else if (dp[i][j] == -1){
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        System.out.println(dp[N][K]);
    }


    public static class Node {
        int weight;
        int value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
