import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int M = Integer. parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            sb.append(isExist(list, 0, N-1, Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb);
    }

    static int isExist(List<Integer> list, int low, int high, int key) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == key) {
                return 1;
            } else if (list.get(mid) > key) {
                return isExist(list, low, mid - 1, key);
            } else {
                return isExist(list, mid + 1, high, key);
            }
        }
        return 0;
    }
}
