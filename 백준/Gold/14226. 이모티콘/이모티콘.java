import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[][] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        System.out.println(bfs());
    }



    public static int bfs() {
        Queue<Emoji> queue = new ArrayDeque<>();
        queue.add(new Emoji(0, 0, 1));
        visit = new boolean[1001][1001];

        while (!queue.isEmpty()) {
            Emoji emoji = queue.poll();
            int sec = emoji.sec;
            int clip = emoji.clip;
            int count = emoji.count;

            if (count == N) return sec;

            if (!visit[count][count]) {
                visit[count][count] = true;
                queue.add(new Emoji(sec + 1, count, count));
            }

            if (clip > 0 && count + clip <= 1000 && !visit[clip][count + clip]) {
                visit[clip][count + clip] = true;
                queue.add(new Emoji(sec + 1, clip, count + clip));
            }

            if (count - 1 > 0 && !visit[clip][count - 1]) {
                visit[clip][count - 1] = true;
                queue.add(new Emoji(sec + 1, clip, count - 1));
            }
        }
        return -1;
    }


    public static class Emoji{
        int sec;
        int clip;
        int count;

        public Emoji(int sec, int clip, int count) {
            this.sec = sec;
            this.clip = clip;
            this.count = count;
        }
    }
}