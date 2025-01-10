import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] array = new int[N];
        int[] array2 = new int[N];
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            array[i] = a;
            array2[i] = a;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(array2);
        int hi = 0;
        for (int a : array2) {
            if (!map.containsKey(a)) {
                map.put(a, hi);
                hi++;
            }
        }

        for (int a : array) {
            sb.append(map.get(a)).append(" ");
        }
        System.out.println(sb);
    }
}
