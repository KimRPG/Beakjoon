package silver.p1074;
//
import java.util.Scanner;

//Z
//public class Main {
//    public static void main(String[] args)  {
//        Scanner s = new Scanner(System.in);
//        int N = s.nextInt();
//        int row = s.nextInt();
//        int col = s.nextInt();
//        int total = 0;
//
//        for (int i = N; i > 0; i--) {
//            int line = (int) Math.pow(2, i);
//            int mux = (int) Math.pow(4, i-1);
//            int result = where(row, col, line);
//            switch (result) {
//                case 3:
//                    row -= (line/2);
//                    col -= (line/2);
//                    total += result * mux;
//                    break;
//                case 2:
//                    row -= (line/2);
//                    total += result * mux;
//                    break;
//                case 1:
//                    col -= (line/2);
//                    total += result * mux;
//                    break;
//                case 0:
//                    total += result * mux;
//                    break;
//            }
//        }
//        System.out.println(total);
//            }
//
//
//
//    public static int where(int row, int col, int line) {
//        boolean rowWhere = row >= (line / 2);
//        boolean colWhere = col >= (line / 2);
//        if (rowWhere) {
//            if (colWhere) {
//                return 3;
//            } else {
//                return 2;
//            }
//        } else {
//            if (colWhere) {
//                return 1;
//            } else {
//                return 0;
//            }
//        }
//    }
//}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int row = s.nextInt();
        int col = s.nextInt();
        System.out.println(func(N, row, col));
    }

    public static int func(int n, int row, int col) {
        if (n == 0) return 0;
        int half = 1 << (n - 1);
        if (row < half && col < half) return func(n - 1, row, col);
        if (row < half && col >= half) return half * half + func(n - 1, row, col - half);
        if (row >= half && col < half) return 2 * half * half + func(n - 1, row - half, col);
        return 3 * half * half + func(n - 1, row - half, col - half);

    }
}