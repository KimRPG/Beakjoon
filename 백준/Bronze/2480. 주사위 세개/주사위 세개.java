import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int prize = 0;
        
        if (a == b && b == c) {
            // 세 주사위의 눈이 모두 같을 때
            prize = 10000 + a * 1000;
        } else if (a == b || a == c) {
            // 두 개의 주사위의 눈이 같을 때 (a와 b, 또는 a와 c)
            prize = 1000 + a * 100;
        } else if (b == c) {
            // 두 개의 주사위의 눈이 같을 때 (b와 c)
            prize = 1000 + b * 100;
        } else {
            // 모든 주사위의 눈이 서로 다를 때
            int max = Math.max(a, Math.max(b, c));
            prize = max * 100;
        }
        
        System.out.println(prize);
    }
}