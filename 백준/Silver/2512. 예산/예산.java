import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int maxRequest = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxRequest = Math.max(maxRequest, arr[i]);
        }

        int m = Integer.parseInt(br.readLine());

        int low = 0;
        int high = maxRequest;
        int answer = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            long currentSum = 0; 

            for (int i = 0; i < n; i++) {
                currentSum += Math.min(arr[i], mid);
            }

            if (currentSum <= m) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}