import java.util.*;
import java.io.*;
public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(binary(0, N - 1, Integer.parseInt(st.nextToken()))).append(" ");
        }
        System.out.println(sb);
    }

    public static int binary(int min, int max, int ans) {
        int mid = (max + min) / 2;
        if (max < min) {
            return 0;
        }
        if (arr[mid] == ans) {
            return 1;
        } else if (arr[mid] > ans) {
            return binary(min, mid - 1, ans);
        }else{
            return binary(mid + 1, max, ans);
        }

    }
}