import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        if(N == 2){
            System.out.println("CY");
            return;
        }
        while (N >= 4) {
            N--;
            count++;
        }

        if (count % 2 == 0 ) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}