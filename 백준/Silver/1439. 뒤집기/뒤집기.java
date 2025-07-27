import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        int ans = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] != a[i]) {
                ans++;
            }
        }
        System.out.println(ans / 2);
    }
}
