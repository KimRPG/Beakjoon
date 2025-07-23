import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
        }
        String[] st = br.readLine().split(" ");
        int start = Integer.parseInt(st[0]);
        int end = Integer.parseInt(st[1]);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = br.readLine().split(" ");
            int a = Integer.parseInt(st[0]) - 1;
            int b = Integer.parseInt(st[1]) - 1;
            arr[a].add(b);
            arr[b].add(a);
        }
        System.out.println(BFS(start - 1, end - 1));
    }

    public static int BFS(int start, int end) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0});
        visit[start] = true;
        while (!q.isEmpty()) {
            int[] ints = q.poll();
            int now = ints[0];
            int c = ints[1];
            if (now == end) {
                return c;
            }
            for (int next : arr[now]) {
                if(visit[next]) continue;
                q.add(new int[]{next, c+1});
                visit[next] = true;
            }

        }
        return -1;
    }
}

