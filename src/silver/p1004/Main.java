package silver.p1004;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        List ans = new ArrayList();

        for (int i = 0; i < testCase; i++) {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            int n = s.nextInt();
            for (int j = 0; j < n; j++) {
                int cx = s.nextInt();
                int cy = s.nextInt();
                int r = s.nextInt();
                circleIn(x1,y1,x2,y2,cx,cy,r);
            }
            ans.add(count);
            count = 0;
        }

        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
    public static void circleIn(int x1, int y1, int x2, int y2 ,int cx,int cy ,int r) {
        boolean circle1 = (x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy) <= r * r;
        boolean circle2 = (x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy) <= r * r;
        if(circle1 ^ circle2) count++;
    }
}

