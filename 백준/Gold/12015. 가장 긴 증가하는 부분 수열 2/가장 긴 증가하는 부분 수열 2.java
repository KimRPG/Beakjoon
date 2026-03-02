import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int current = arr[i];
            int idx = Collections.binarySearch(lis, current);

            if (idx < 0) {
                int insertionPoint = -(idx + 1);

                if (insertionPoint == lis.size()) {
                    lis.add(current);
                }
                else {
                    lis.set(insertionPoint, current);
                }
            }
        }

        System.out.println(lis.size());
    }
}