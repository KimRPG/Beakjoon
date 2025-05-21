import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answ = 0;
        for (int i = N; i >= 0; i--) {
            answ += i;
        }
        System.out.println(answ);

    }
}