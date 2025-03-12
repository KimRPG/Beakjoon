import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] time = new int[100001];   // 최소 시간 저장
    static int[] count = new int[100001];  // 해당 시간에 도달하는 경우의 수 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == M) {
            System.out.println(0);
            System.out.println(1);
        } else {
            bfs();
            System.out.println(time[M]);
            System.out.println(count[M]);
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        time[N] = 0;
        count[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000) continue;

                if (time[next] == 0) {
                    time[next] = time[now] + 1;
                    count[next] = count[now]; 
                    queue.add(next);
                } else if (time[next] == time[now] + 1) { 
                    count[next] += count[now]; 
                }
            }
        }
    }
}
