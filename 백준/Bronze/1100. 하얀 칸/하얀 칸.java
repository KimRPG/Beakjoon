import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {;
                if ((i + j) % 2 == 0 && chars[j] == 'F') ans++;
            }
        }
        System.out.println(ans);
    }
}
