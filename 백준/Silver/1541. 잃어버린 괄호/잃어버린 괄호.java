import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split("-");
        int ans = 0;

        for (String a : st[0].split("[+]")) {
            ans += Integer.parseInt(a);
        }
        for (int i = 1; i < st.length; i++) {
            int b = 0;
            String[] st2 = st[i].split("[+]");
            for (String a : st2) {
                b += Integer.parseInt(a);
            }
            ans -= b;
        }

        System.out.println(ans);

    }
}