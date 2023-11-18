package silver.p1032;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        int[] hi = new int[50];
        String sent = s.nextLine();
        for (int i = 0; i < N-1; i++) {
            String sent2 = s.nextLine();
            for (int j = 0; j < sent.length(); j++) {
                if(sent.charAt(j) == sent2.charAt(j)){
                    hi[j] += 1;
                }
            }
        }
        for (int i = 0; i < sent.length(); i++) {
            if (hi[i] == N - 1) {
                System.out.print(sent.charAt(i));
            }
            else {
                System.out.print("?");
            }
        }
    }
}
