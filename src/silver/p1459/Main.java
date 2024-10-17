package silver.p1459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static Integer Macro(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Macro(st.nextToken());
        long y = Macro(st.nextToken());
        long w = Macro(st.nextToken());
        long s = Macro(st.nextToken());
        long ans1, ans2, ans3;

        ans1 =  (x + y) * w;

        if ((x + y) % 2 == 0) {
            ans2 = Math.max(x, y) * s;
        }else {
            ans2 = (Math.max(x, y) - 1) * s + w;
        }
        ans3 = Math.min(x, y) * s + Math.abs(x - y) * w;

        System.out.println(Math.min(ans1, Math.min(ans2, ans3)));
    }
}
