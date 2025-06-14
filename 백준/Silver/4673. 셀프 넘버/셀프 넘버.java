import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] isSolo = new boolean[10001];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10000; i++) {
            int solo = num(i);
            if (solo < 10001) {
                isSolo[solo] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!isSolo[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static int num(int num) {
        int a = num;
        while (num != 0) {
            a += num % 10;
            num = num / 10;
        }

        return a;
    }

}
