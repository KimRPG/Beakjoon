package silver.p1003;

import java.util.Scanner;

public class Main {
    static long[] arr;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        for(int i = 0; i < N + 1; i++) {
            arr[i] = -1;
        }
        arr[0] = 0;
        arr[1] = 1;
        System.out.println(fib(N));
    }

    public static long fib(int n) {
        if (arr[n] == -1) {
            arr[n] = fib(n - 1) + fib(n - 2);
        }
        return arr[n];
    }
}


