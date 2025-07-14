import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[K];
        long max = 0;
        long min = 1;
        long result = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        while (min <= max) {
            long mid = (min + max) / 2;
            if (line(N, arr, mid)) {
                result = mid;
                min = mid + 1;

            }else{
                max = mid - 1;
            }

        }
        System.out.println(result);

    }

    public static boolean line(int N, int[] arr, long mid) {
        int num = 0;
        for (int a : arr) {
            num += a / mid;
        }
        return N <= num;
    }
}