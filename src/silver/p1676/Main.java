package silver.p1676;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (i % 125 == 0) {
                result += 3;
            } else if (i%25==0) {
                result += 2;
            } else if (i%5==0) {
                result += 1;
            }
        }
        System.out.println(result);

    }

}
