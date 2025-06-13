import java.io.*;
import java.util.*;

public class Main {
    static int[][] array = {{0, 1, 2}, {0, 1, 3}, {0, 1, 4}, {0, 2, 3}, {0, 2, 4},
            {0, 3, 4}, {1, 2, 3}, {1, 2, 4}, {1, 3, 4}, {2, 3, 4}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[5];
        int ans = 0;
        int maxOne = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int[] b : array) {
                int one = 0;
                for (int a : b) {
                    one += arr[a];
                }
                one %= 10;
                if (maxOne <= one) {
                    maxOne = one;
                    ans = i + 1;
                }
            }
        }
        System.out.println(ans);

    }

}
