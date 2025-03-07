import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        long a = 0;
        long mod = 1234567891;
        long c = 1; // 31^i 값을 저장할 변수

        for (int i = 0; i < N; i++) {
            int b = chars[i] - 'a' + 1;
            a = (a + (b * c) % mod) % mod; // (b * c)를 모듈러 연산 후 더하기
            c = (c * 31) % mod; // c값을 31배 하면서 모듈러 연산 적용
        }
        System.out.println(a);
    }
}
