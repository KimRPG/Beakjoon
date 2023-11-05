package silver.p1564;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long fac = 1;
        String strN;
        for (int i = 1; i < n+1; i++) {
            fac *= i;
            while (fac % 10 == 0) {
                fac = fac / 10;
            }
            strN = Long.toString(fac);

            if (strN.length() > 5) {
                strN = strN.substring(strN.length() - 6, strN.length());
            }
            fac = Integer.parseInt(strN);
        }
        String str = String.format("%05d", fac);
        str = str.substring(1);
        System.out.println(str);
    }
}
