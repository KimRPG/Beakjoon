import java.util.*;
import java.io.*;

public class Main {

    static int N, S;
    static int ans = Integer.MAX_VALUE;  // 더 큰 값으로 초기화
    static ArrayList<Point> home;
    static ArrayList<Point> chic;
    static Point[] ansChic;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        home = new ArrayList<>();
        chic = new ArrayList<>();
        ansChic = new Point[S];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    home.add(new Point(i, j));
                } else if (a == 2) {
                    chic.add(new Point(i, j));
                }
            }
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    public static void dfs(int at, int depth) {
        if (depth == S) {
            ans = Math.min(ans, dist(Arrays.asList(ansChic)));  // List로 변환하여 전달
            return;
        }

        for (int i = at; i < chic.size(); i++) {
            ansChic[depth] = chic.get(i);
            dfs(i + 1, depth + 1);
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int dist(List<Point> selectedChickens) {
        int totalDist = 0;
        for (Point h : home) {
            int minDist = Integer.MAX_VALUE;
            for (Point c : selectedChickens) {
                minDist = Math.min(minDist, Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
            }
            totalDist += minDist;
        }
        return totalDist;
    }
}
