import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0과 1 제외한 소수
        boolean[] prime = new boolean[1001];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        int n = (int) Math.sqrt(1000);
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                int j = 2;
                while (i * j <= 1000) {
                    prime[i * j] = false;
                    j += 1;
                }
            }
        }
        int[] list = new int[N];
        int a = 0;

        for (int i = 0; i < N; i++) {
            list[i] = (Integer.parseInt(st.nextToken()));
        }

        for (int primeNumber : list) {
            if(prime[primeNumber]) a++;
        }
        System.out.println(a);
    }
}