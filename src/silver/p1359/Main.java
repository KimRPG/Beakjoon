package silver.p1359;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        double nCm = countCombinations(n, m);
        double total = 0;
        for (int i = 0; i < k; i++) {
            total += countCombinations(n - m, m - i) * countCombinations(m, i);
        }
        System.out.println((nCm - total) / nCm);
    }

    public static float countCombinations(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        if (k > n) {
            return 0;
        }
        return countCombinations(n - 1, k - 1) + countCombinations(n - 1, k);
    }
}
