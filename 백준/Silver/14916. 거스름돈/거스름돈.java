import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int five = money / 5;
        int two;
        money -= five * 5;
        if (money % 2 == 0) {
            two = money / 2;
        }else {
            five--;
            money += 5;
            two = money / 2;
        }
        if (five < 0 || two < 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(two + five);

    }
}
