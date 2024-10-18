import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static Integer Macro(String st) {
        return Integer.parseInt(st);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Macro(st.nextToken());
        int K = Macro(st.nextToken());

        int result = 0;
        int a = 0;
        ArrayList list = new ArrayList();
        for (int i = 0; i < N; i++) {
            list.add(Macro(br.readLine()));
        }

        list.sort(Comparator.reverseOrder());

        while (K != 0) {
            int add = K /(int) list.get(a);
            result += add;
            K -= (int) list.get(a) * add;
            a++;
        }
        System.out.println(result);
    }
}
