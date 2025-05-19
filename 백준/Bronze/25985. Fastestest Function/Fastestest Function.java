import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        double y = sc.nextDouble();

        double result = (x * (100 - y)) / (y * (100 - x));

        System.out.printf("%.10f\n", result);
    }
}