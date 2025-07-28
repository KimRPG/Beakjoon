import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visit = new boolean[N];
        back(0);
        System.out.println(sb);

    }

    public static void back(int depth) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++) {
            if(visit[i])
                continue;

            arr[depth] = i + 1;
            visit[i] = true;
            back(depth + 1);
            visit[i] = false;
        }

    }
}
