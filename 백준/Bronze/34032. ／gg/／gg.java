import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        for (char ch : br.readLine().toCharArray()) {
            if (ch == 'O') {
                a++;
            }
            if (a >= (N+1) / 2) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");

    }
}
