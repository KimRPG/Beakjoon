import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
            result[i] = time;
            int a = Integer.parseInt(st.nextToken());
            for (int j = 0; j < a; j++) {
                result[i] = Math.max(result[i], result[Integer.parseInt(st.nextToken()) - 1] + times[i]);
            }
        }
        int max = 0;
        for (int a : result) {
            max = Math.max(a, max);
        }

        System.out.println(max);
    }
}
