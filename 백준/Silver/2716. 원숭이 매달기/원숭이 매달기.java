import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            int a = 0;
            int max = 0;
            for (char c : ch) {
                if (c == '[') {
                    a++;
                }else{
                    max = Math.max(a, max);
                    a--;

                }
            }
            sb.append((int) Math.pow(2, max)).append("\n");
        }

        System.out.println(sb);
    }
}
