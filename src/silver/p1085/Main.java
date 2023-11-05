package silver.p1085;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int y = s.nextInt();
        int w = s.nextInt();
        int h = s.nextInt();

        List distance = new ArrayList();

        distance.add(x);
        distance.add(y);
        distance.add(w - x);
        distance.add(h - y);

        int minDistance = (Integer) Collections.min(distance);
        System.out.println(minDistance);

    }
}
