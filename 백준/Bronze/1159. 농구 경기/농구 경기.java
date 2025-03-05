import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char name = br.readLine().charAt(0);
            if (map.containsKey(name)) {
                int a = map.get(name);
                map.put(name, a + 1);
            }else {
                map.put(name, 1);
            }
        }

        map.forEach((key, value)->{
            if (value >= 5) {
                sb.append(key);
            }
        });
        System.out.println(sb.length() == 0 ? "PREDAJA" : sb);
    }
}