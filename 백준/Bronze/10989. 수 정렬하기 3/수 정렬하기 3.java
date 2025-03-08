import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10000];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine()) - 1;
            arr[a]++;
        }
        for (int i = 0; i < 10000; i++) {
            if (arr[i] != 0) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i + 1).append("\n");
                }
            }

        }
        System.out.print(sb);
    }
}
