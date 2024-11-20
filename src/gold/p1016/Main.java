//package gold.p1016;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//    static Long Macro(String string) {
//        return Long.parseLong(string);
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        Long min = Macro(st.nextToken());
//        Long max = Macro(st.nextToken());
//        int count = (int) (max - min + 1);
//        boolean[] result = new boolean[count];
//        for (long i = 2; i * i < max; i++) {
//            long squareNumber = i*i;
//
//            long start = min%squareNumber == 0 ? min/squareNumber : (min/squareNumber)+1;
//
//            for (long j = start;  squareNumber*j<=max; j++) {
//                int index = (int)( squareNumber * j - min);
//                if(!result[index]) {
//                    result[index] = true;
//                }
//            }
//        }
//
//        for (boolean b : result) {
//            if (b) {
//                count--;
//            }
//        }
//        System.out.println(count);
//    }
//}
package gold.p1016;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long count = max-min+1;
        boolean[] arr = new boolean[(int)count];

        int answer = 0;
        for (long num = 2; num <= (int)Math.sqrt(max); num++) {
            long squareNumber = num*num;
            //System.out.printf("squareNumber: %d ", squareNumber);

            long start = min%squareNumber == 0 ? min/squareNumber : (min/squareNumber)+1;
            //System.out.printf("start: %d ", start);

            for (long j = start; squareNumber*j <= max; j++) {
                int index = (int)(squareNumber*j-min);

                if (arr[index]) continue;
                else {
                    arr[index] = true;
                    answer++;
                }
            }
        }
        System.out.println(count-answer);
    }
}