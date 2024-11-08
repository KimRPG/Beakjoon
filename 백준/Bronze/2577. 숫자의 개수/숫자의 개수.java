import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int[] a = new int[10];
        Long ans =((long) A * B * C);
        while (ans > 0) {
            a[(int)(ans % 10)]++;
            ans /= 10;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }
}