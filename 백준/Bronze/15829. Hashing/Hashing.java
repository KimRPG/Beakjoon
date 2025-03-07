import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        long a = 0;
        for (int i = 0; i < N; i++) {
            long c = 1;
            int b = chars[i] - 'a' + 1;
            for (int j = 0; j < i; j++) {
                c *= 31;
                c %= 1234567891;
            }
            a += b * c;
        }
        System.out.println(a);
    }
}