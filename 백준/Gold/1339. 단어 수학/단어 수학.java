import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < chars.length; j++) {
                arr[chars[j] - 'A'] -= (int) Math.pow(10, chars.length-1 - j);
            }
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < 10; i++) {
            ans -= arr[i] * (9 - i);
        }
        System.out.println(ans);
    }
}
