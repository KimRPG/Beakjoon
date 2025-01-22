import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        Queue<long[]> queue = new LinkedList<>();

        long result = -1;

        queue.add(new long[]{A, 1});
        while (!queue.isEmpty()) {
            long[] arr = queue.poll();
            long a = (long) arr[0];
            long ans = arr[1];
            if (a == B) {
                result = ans;
                break;
            } else if (a < B) {
                ans++;
                queue.add(new long[]{2 * a, ans});
                queue.add(new long[]{10 * a + 1, ans});
            }
        }
        System.out.println(result);
    }

}
