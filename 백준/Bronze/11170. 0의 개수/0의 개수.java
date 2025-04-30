import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for (int j = a; j <= b; j++) {
                char[] hi = String.valueOf(j).toCharArray();
                for (char ch : hi) {
                    if(ch == '0') ans++;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}