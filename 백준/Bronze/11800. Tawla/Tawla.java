import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[][] mat = {{"", "Yakk", "Doh", "Seh", "Ghar", "Bang", "Sheesh"}, {"", "Habb Yakk", "Dobara", "Dousa", "Dorgy", "Dabash", "Dosh"}};
        int t = read();
        for (int i = 1; i <= t; i++) {
            sb.append("Case ").append(i).append(": ");
            int a = read(), b = read();
            if (a == b) sb.append(mat[1][a]).append('\n');
            else if (a + b != 11)
                sb.append(mat[0][Math.max(a, b)]).append(' ').append(mat[0][Math.min(a, b)]).append('\n');
            else sb.append("Sheesh Beesh\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}