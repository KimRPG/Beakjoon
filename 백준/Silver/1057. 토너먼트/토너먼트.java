import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int han = Integer.parseInt(st.nextToken());

        int ans = 0;
        while (jimin != han) {
            jimin = (jimin + 1) / 2;
            han = (han + 1) / 2;
            ans++;
        }
        System.out.println(ans);
    }
}
