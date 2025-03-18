import java.io.*;
import java.util.*;
public class Main{
    static int[] arr, ans;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            ans = new int[6];
            for (int i = 0; i < N; i++) {
                int a = Integer.parseInt(st.nextToken());
                arr[i] = a;
            }
            back(0, 0);

            sb.append("\n");
        } while (N != 0);

        System.out.println(sb);
    }

    public static void back(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < depth; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < N; i++) {
            ans[depth] = arr[i];
            back(i + 1, depth + 1);
        }
    }
}