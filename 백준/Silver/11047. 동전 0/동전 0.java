import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt((st.nextToken()));
        int K = Integer.parseInt((st.nextToken()));

        int result = 0;
        int a = N-1;
        ArrayList list = new ArrayList();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        while (K != 0) {
            int add = K /(int) list.get(a);
            result += add;
            K -= (int) list.get(a) * add;
            a--;
        }
        System.out.println(result);
    }
}