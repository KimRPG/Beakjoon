import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String string = st.nextToken();
            if (string.endsWith("Cheese")) {
                map.put(string, 0);
            }
        }
        System.out.println(map.size() >= 4 ? "yummy" : "sad");
    }
}