package silver.P1026;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt(); // 배역의 수
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            a.add(s.nextInt());
        }
        for (int i = 0; i < n; i++) {
            b.add(s.nextInt());
        }
        Collections.sort(a);
        Collections.sort(b, Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int aNum = (Integer) a.get(i) * (Integer) b.get(i);
            ans += aNum;
        }
        System.out.println(ans);

    }
}
