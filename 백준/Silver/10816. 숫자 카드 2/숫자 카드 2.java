import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)) {
                int b = map.get(a);
                map.put(a, b + 1);
            }else {
                map.put(a, 1);
            }
        }
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)) {
                sb.append(map.get(a)).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
