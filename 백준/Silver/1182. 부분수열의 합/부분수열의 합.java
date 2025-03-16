import java.util.*;
import java.io.*;
import java.util.concurrent.CancellationException;

public class Main {

    static int[] arr;
    static int N,S;
    static int ans = 0;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (S == 0) {
            ans--;
        }
        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int depth, int var) {
//        for (int j = 0; j < N; j++) {
//            if (visit[j]) {
//                System.out.print(arr[j] +" ");
//            }
//        }
//        System.out.println(": "+ var);
        if (var == S) {
            ans++;
        }
        if (depth >= N) {
            return;
        }
        for (int i = depth; i < N; i++) {
            if(visit[i]) continue;
            visit[i] = true;
            int nVar = var + arr[i];
            dfs(++depth, nVar);
            visit[i] = false;
        }
    }

}
