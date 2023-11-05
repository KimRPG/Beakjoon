package silver.p9012;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int sum = 0;
    public static void main(String[] args) {
        String result = "";
        List hi = new ArrayList<String>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for (int i = 0; i < n; i++) {
            String bracket = s.nextLine();
            result=bracketSum(bracket);
            hi.add(result);
        }
        for (int i = 0; i < hi.size(); i++) {
            System.out.println(hi.get(i));
        }


    }

    public static String bracketSum(String hi) {
            for (int i = 0; i < hi.length(); i++) {
                if (sum < 0) {
                    break;
                }
                if (hi.charAt(i) == '(') {
                    sum += 1;
                }else if(hi.charAt(i)==')'){
                    sum -= 1;
                }
        }
        if (sum == 0) {
            sum = 0;
            return "YES";
        }

        sum = 0;
        return "NO";
    }


}
