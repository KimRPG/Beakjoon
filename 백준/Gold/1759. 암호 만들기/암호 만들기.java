import java.io.*;
import java.util.*;
public class Main{
    static char[] ans,arr;
    static int C, L;
    static StringBuilder sb = new StringBuilder();
    static Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        ans = new char[L];
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        back(0, 0);
        System.out.println(sb);
    }

    public static void back(int start, int depth) {
        if (depth == L) {
            int a = 0;
            for (int i = 0; i < depth; i++) {
                if (set.contains(ans[i])) {
                    a++;
                }
            }
            if (a >= 1 && L - a >= 2) {
                for (int i = 0; i < depth; i++) {
                    sb.append(ans[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            ans[depth] = arr[i];
            back(i + 1, depth + 1);
        }
    }
}