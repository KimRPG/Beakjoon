import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer> arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (!arr.contains(a)) {
                arr.add(a);
            }
        }
        arr.sort(Comparator.naturalOrder());
        back(0);
        System.out.println(sb);
    }

    public static void back(int depth) {
        if (depth == M) {
            boolean check = false;
            for (int i = 1; i < M; i++) {
                if (ans[i] < ans[i - 1]) {
                    check = true;
                    break;
                }
            }


            if(!check){
                for (int i = 0; i < M; i++) {
                    sb.append(ans[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
        for (Integer integer : arr) {
            ans[depth] = integer;
            back(depth + 1);
        }
    }
}
