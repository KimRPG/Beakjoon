import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] a = new int[1_000_002];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        a[1] = 1; a[2]= 1; a[3] = 1;
        if(N==1) System.out.println(0);
        else System.out.println(divide(N));
    }

    static int divide(int number) {
        if(a[number] !=0) return a[number];
        else {
            return a[number] = Math.min(divide(number / 3) + 1 + number % 3, divide(number / 2) + 1 + number % 2);
        }
    }

}
