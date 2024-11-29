import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());
            sb.append(how(start, end)).append("\n");
        }
        System.out.println(sb);
    }

    static int how(long start, long end) {
        long length = end- start;
        int root = (int) Math.sqrt(length);
        if (length == (long) root * root) {
            return root * 2 - 1;
        }
        else{
            if (length <= ((long) root * root + root)) {
                return root * 2 ;
            }else {
                return root * 2 + 1;
            }
        }

    }
}
