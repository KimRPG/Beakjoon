package algorithm.dp;

import java.io.*;


public class Fibonacci {


    static int[] arr = new int[50];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr[0] = 0;
        arr[1] = 1;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                sb.append("1").append(" ").append("0").append("\n");
                continue;
            }
            sb.append(fibonacci(a-1)).append(" ").append(fibonacci(a)).append("\n");

        }
        System.out.println(sb);
    }


    static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return arr[n];
    }
}
