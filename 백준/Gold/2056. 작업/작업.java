import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] inDegree = new int[N];
        int[] times = new int[N];
        int[] result = new int[N];
        List<Integer>[] arr = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] =  Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            inDegree[i] = num;
            for (int j = 0; j < num; j++) {
                int to = Integer.parseInt(st.nextToken());
                arr[to-1].add(i);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = times[i];
            }
        }
        while (!queue.isEmpty()) {
            int vertices = queue.poll();
            for (int a : arr[vertices]) {
                inDegree[a]--;
                result[a] = Math.max(result[a], result[vertices] + times[a]);
                if (inDegree[a] == 0) {
                    queue.add(a);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, result[i]);
        }

        System.out.println(max);

    }
}
