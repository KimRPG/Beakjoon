import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visit;
    static boolean arrived;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ... (main 메소드의 앞부분은 동일) ...
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        arrived = false;
        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            back(i, 0);
            if (arrived) {
                break;
            }
        }

        if (arrived) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void back(int start, int depth) {
        if (depth >= 4) {
            arrived = true;
            return;
        }

        visit[start] = true;

        for (int next : arr.get(start)) {
            if (!visit[next]) {
                back(next, depth + 1);
                if (arrived) return;
            }
        }
        
        visit[start] = false;
    }
}