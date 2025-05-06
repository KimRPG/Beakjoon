import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken()) - 1;
        if (k > n - k) k = n - k;  // 대칭성 이용
        long result = 1;

        for (int i = 1; i <= k; i++) {
            result *= (n - i + 1);
            result /= i;
        }

        System.out.println(result);

    }
}