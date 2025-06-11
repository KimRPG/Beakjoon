import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        if (N <= 3) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < 4; i++) {
            ans *= (N - i);
        }
        ans /= 24;
        System.out.println(ans);
    }
}

