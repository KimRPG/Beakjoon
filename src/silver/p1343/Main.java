package silver.p1343;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int count = 0;
        StringBuilder sb = new StringBuilder();


        for (char x : line.toCharArray()){
            if (x == 'X') {
                count++;
                
            } else if (count % 2 != 0) {
                System.out.println(-1);
                break;
            }else {
                if (count >= 4) {
                    count -= 4;
                    sb.append("AAAA");
                } else if (count >= 2) {
                    count -= 2;
                    sb.append("BB");
                }
            }
            sb.append('.');
        }
    }
}
