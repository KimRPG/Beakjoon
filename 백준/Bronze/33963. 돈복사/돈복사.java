import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();  // 초기 금액
        int count = 0;

        int originalLength = String.valueOf(n).length();

        while (true) {
            n *= 2;
            if (String.valueOf(n).length() != originalLength) {
                break;
            }
            count++;
        }

        System.out.println(count);
    }
}
