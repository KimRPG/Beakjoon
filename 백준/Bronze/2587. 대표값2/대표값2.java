import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int max = 0;
        for (int i = 0; i < 5; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            max += a;
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        sb.append(max / 5).append("\n");
        sb.append(arr[2]).append("\n");
        System.out.println(sb);
    }
}
