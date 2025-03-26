import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, ans;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        ans = new int[M];
        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        back(0,0);
        System.out.println(sb.toString());
    }

    public static void back(int n,int start) {
        if (n == M) {
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            ans[n] = arr[i];
            back(n + 1, i );
        }
    }
}