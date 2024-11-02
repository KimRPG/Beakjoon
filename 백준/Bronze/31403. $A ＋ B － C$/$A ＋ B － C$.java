import java.io.*;


public class Main {
    static int countDigit(int num) {
        int count = 1;
        while (num > 0) {
            num /= 10;
            count *= 10;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int digit = countDigit(b);
        System.out.println(a+b-c);
        System.out.println(a*digit+b-c);
    }
}