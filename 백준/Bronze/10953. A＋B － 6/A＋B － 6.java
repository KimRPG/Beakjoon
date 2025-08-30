import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(",");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}