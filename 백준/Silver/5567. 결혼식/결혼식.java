import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        visit = new boolean[N];
        visit[0] = true;
        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i = 0; i < M ; i++){
            String[] st = br.readLine().split(" ");
            int start = Integer.parseInt(st[0]) - 1;
            int end = Integer.parseInt(st[1]) - 1;
            arr.get(start).add(end);
            arr.get(end).add(start);
        }
        BFS(0);
        int ans = 0;
        for (boolean b : visit) {
            if(b) ans++;
        }
        System.out.println(ans - 1);
    }

    public static void BFS(int N) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int b : arr.get(N)) {
            if (!visit[b]) {
                q.add(b);
                visit[b] = true;
            }
        }
        while (!q.isEmpty()) {
            int a = q.poll();
            for (int b : arr.get(a)) {
                if (!visit[b]) {
                    visit[b] = true;
                }
            }
        }
    }
}