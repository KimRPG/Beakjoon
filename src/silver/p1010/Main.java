package silver.p1010;
//
//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class Main {
//    static BigInteger[] dp;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        dp = new BigInteger[60];
//        System.out.println(calculateCombination(n, m));
//
//    }
//
//    static BigInteger calculateCombination(int k, int n) {
//        if (k < 0 || k > n) return BigInteger.ZERO; // k가 범위를 벗어나면 조합은 0
//        BigInteger numerator = factorial(n);
//        BigInteger denominator = factorial(k).multiply(factorial(n - k));
//        return numerator.divide(denominator);
//    }
//    static BigInteger factorial(int x) {
//        if (x == 0) return BigInteger.ONE; // 0! = 1
//        if (dp[x] != null) return dp[x];
//        dp[x] = BigInteger.valueOf(x).multiply(factorial(x - 1));
//        return dp[x];
//    }
//}

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[][] dp = new int[30][30];

        // 2번 성질 (n == r, r == 0)
        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }


        for (int i = 2; i < 30; i++) {
            for (int j = 1; j < 30; j++) {
                // 1번 성질
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }



        int T = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++) {

            // M개중 N개를 뽑는 경우이므로 nCr 에서 n = M, r = N이다.
            int N = in.nextInt();	// N = r
            int M = in.nextInt();	// M = n

            sb.append(dp[M][N]).append('\n');
        }

        System.out.println(sb);

    }
}
