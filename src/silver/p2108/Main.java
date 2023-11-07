package silver.p2108;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        List numList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            numList.add(num);
        }
        numList.sort(Comparator.naturalOrder());
        for (int i = 0; i < n; i++) {
            System.out.println(numList.get(i));
        }
    }


}
