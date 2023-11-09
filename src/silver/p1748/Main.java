package silver.p1748;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Long N = s.nextLong();
        Long ret = N;
        int m = 0;
        int total=0;
        while (N>0){
            N /= 10;
            m+=1;
        }
        for (int i = 1; i < m; i++) {
            double ten = Math.pow(10, i-1);
            total += i * (9 * ten);
        }
        Long retMINm = (long) (ret - Math.pow(10, m-1)) +1;

        for (int i = 0; i < retMINm; i++) {
            total += m;
        }
        System.out.println(total);
    }
}
