import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans *= i;
        }
        for (int i = a; i >0 ; i --) {
            ans /= i;
        }
        for (int i = b; i >0 ; i --) {
            ans /= i;
        }
        for (int i = c; i >0 ; i --) {
            ans /= i;
        }
        System.out.println(ans);
    }
}