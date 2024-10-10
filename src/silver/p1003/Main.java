package silver.p1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new long[N + 1];
            for(int j = 0; j < N + 1; j++) {
                arr[j] = -1;
            }
            arr[0] = 0;
            arr[1] = 1;

            System.out.println(fib(N));
            System.out.println(fib(N-1));
        }


    }

    public static long fib(int n) {
        if (arr[n] == -1) {
            arr[n] = fib(n - 1) + fib(n - 2);
        }
        return arr[n];
    }
}


