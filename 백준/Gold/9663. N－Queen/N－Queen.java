import java.util.*;
import java.io.*;
import java.util.concurrent.CancellationException;

public class Main {

    static int[] arr;
    static int N;
    static int ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            ans++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (nQueenCan(depth)) {
                dfs(depth + 1);
            }
        }
    }

    public static boolean nQueenCan(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }



}
