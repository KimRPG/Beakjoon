import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 2;
        arr[5] = 3;
        for (int i = 0; i < 100; i++) {
            if(arr[i] == 0) arr[i] = arr[i - 1] + arr[i - 5];
        }

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            sb.append(arr[a - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
