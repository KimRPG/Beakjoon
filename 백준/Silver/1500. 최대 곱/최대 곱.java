import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double S = Double.parseDouble(st.nextToken());
        double K = Double.parseDouble(st.nextToken());
        int ans = (int) (S / K);
        int remain = (int) (S - ans * K);
        long result;
        result = (long) Math.pow(ans+1,remain);
        result *= (long) Math.pow(ans,K-remain);

        System.out.println(result);
    }
}
