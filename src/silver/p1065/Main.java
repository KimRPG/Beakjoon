package silver.p1065;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int number = s.nextInt();
        int answer = count(number);


        System.out.println(answer);

    }

    public static int count(int number) {
        int answer =0;
        for (int i = number; i > 0 ; i--) {
            if(i<100) answer += 1;
                else {
                int number1 = i / 100;
                int number2 = i % 100 / 10;
                int number3= i %100%10;
                if (number2 * 2 == number1 + number3) {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
