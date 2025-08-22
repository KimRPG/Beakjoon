import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        if (N == 1) {
            System.out.println(1);
            return;
        }
        System.out.println(fibo(N - 1));
    }

    public static int fibo(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}