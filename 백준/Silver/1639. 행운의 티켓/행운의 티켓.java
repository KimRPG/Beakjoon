import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();

        for (int len = n; len >= 2; len--) {
            if (len % 2 != 0) continue; // 홀수 길이는 패스
            for (int start = 0; start <= n - len; start++) {
                String substr = s.substring(start, start + len);
                if (isLucky(substr)) {
                    System.out.println(len);
                    return;
                }
            }
        }

        System.out.println(0); // 없을 경우
    }

    public static boolean isLucky(String str) {
        int half = str.length() / 2;
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < half; i++) {
            sum1 += str.charAt(i) - '0';
        }
        for (int i = half; i < str.length(); i++) {
            sum2 += str.charAt(i) - '0';
        }

        return sum1 == sum2;
    }
}
