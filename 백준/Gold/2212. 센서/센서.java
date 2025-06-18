import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dif = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N - 1; i++) {
            dif[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(dif);
        int ans = 0;
        for (int i = 0; i < N - K; i++) {
            ans += dif[i];
        }
        System.out.println(ans);
    }

}
