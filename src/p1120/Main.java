package p1120;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string1 = scanner.next();
        String string2 = scanner.next();

        int len1 = string1.length();
        int len2 = string2.length();
        int length = len2 - len1;
        int[] count = new int[100];
        int temp = 100;

        for (int i = 0; i <= length; i++) {
            for (int j = 0; j < len1; j++) {
                System.out.println(string1.charAt(j) + " "+ string2.charAt(j + i));
                if (string1.charAt(j) != string2.charAt(j + i)) {
                    System.out.println("여기야");
                    count[i]++;
                }
            }
            if (temp > count[i]) {
                temp = count[i];
            }
        }

        System.out.println(temp);
    }
}
