package silver.p2097;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long N = s.nextLong();
        long root = (long) Math.sqrt(N);
        long sub = N - (long) Math.pow(root, 2);
        long length;
        if (N < 3) {
            System.out.println(4);
        }
        else {
            if (sub > root) {
            length = 4 * (root - 1) + 4;
        } else if (sub == 0) {
            length = 4 * (root - 1);
        }else  {
            length = 4 * (root - 1) + 2;
        }
            System.out.println(length);
        }

    }
}
