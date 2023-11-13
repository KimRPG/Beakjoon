package silver.p14912;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int want = s.nextInt();
        int ans = 0;

        for (int i = 0; i <= N; i++) {
            int result = i;
            while (result != 0) {
                int hi = result % 10;
                if(hi == want){
                    ans+=1;
                }
                result /= 10;
            }
        }
        System.out.println(ans);
    }
}
