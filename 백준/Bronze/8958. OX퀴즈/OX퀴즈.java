import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] a = br.readLine().toCharArray();
            int hi=0;
            int ans = 0;
            for (char ch : a) {
                if (ch == 'O') {
                    hi++;
                    ans += hi;
                }else {
                    hi = 0;
                }
                }
            sb.append(ans).append("\n");
            }
        System.out.println(sb);
        }

}

