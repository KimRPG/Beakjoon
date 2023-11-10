package silver.p1024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int L = s.nextInt();
        List<Integer> ans = new ArrayList<>();

        for (int i = L; i <= 100; i++) {
            if (i % 2 == 1) { // 홀수
                if (N % i == 0) { // 깔끔하게 나누어지면
                    int start = N / i - (i - 1) / 2;
                    if (start >= 0) {
                        for (int j = 0; j < i; j++) {
                            ans.add(start + j);
                        }
                        break;
                    }
                }
            } else { // 짝수
                if (N % i == i / 2) { // 깔끔하게 나누어지면
                    int start = N / i - i / 2 + 1;
                    if (start >= 0) {
                        for (int j = 0; j < i; j++) {
                            ans.add(start + j);
                        }
                        break;
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if (i < ans.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
