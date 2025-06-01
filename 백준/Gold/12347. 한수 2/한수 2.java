import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static BigInteger N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = new BigInteger(sc.next());
        sc.close();

        // 1~99까지는 무조건 한수
        if (N.compareTo(BigInteger.valueOf(100)) < 0) {
            System.out.println(N);
            return;
        }

        count = 99; // 1자리 ~ 2자리 숫자 전부 포함

        int len = N.toString().length();

        for (int l = 3; l <= len; l++) {
            for (int d = -9; d <= 9; d++) {
                for (int a = 1; a <= 9; a++) {
                    StringBuilder sb = new StringBuilder();
                    int curr = a;
                    boolean valid = true;

                    for (int i = 0; i < l; i++) {
                        if (curr < 0 || curr > 9) {
                            valid = false;
                            break;
                        }
                        sb.append(curr);
                        curr += d;
                    }

                    if (valid) {
                        BigInteger num = new BigInteger(sb.toString());
                        if (num.compareTo(N) <= 0) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
