import java.io.*;
import java.util.*;
public class Main {
    public static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            visit = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(bfs(start, end));

        }
    }




    public static int D(int a) {
            return (2 * a) % 10000;
    }
    public static int S(int a) {
        if(a == 0) return 9999;
        return a - 1;
    }
    public static int L(int a) {
        return (a % 1000) * 10 + (a / 1000);
    }

    public static int R(int a) {
        return (a / 10) + (a % 10) * 1000;
    }


    public static String bfs(int start, int end) {
        boolean[] visit = new boolean[10000]; // 방문 여부 배열 초기화
        Queue<Ans> queue = new LinkedList<>(); // BFS 큐
        queue.add(new Ans(start, "")); // 시작 상태 추가
        visit[start] = true; // 시작 상태 방문 표시

        while (!queue.isEmpty()) {
            Ans current = queue.poll();
            int number = current.number;
            String path = current.ans;

            if (number == end) {
                return path; // 목표 숫자에 도달하면 경로 반환
            }

            // D 명령
            int d = D(number);
            if (!visit[d]) {
                visit[d] = true;
                queue.add(new Ans(d, path + "D"));
            }

            // S 명령
            int s = S(number);
            if (!visit[s]) {
                visit[s] = true;
                queue.add(new Ans(s, path + "S"));
            }

            // L 명령
            int l = L(number);
            if (!visit[l]) {
                visit[l] = true;
                queue.add(new Ans(l, path + "L"));
            }

            // R 명령
            int r = R(number);
            if (!visit[r]) {
                visit[r] = true;
                queue.add(new Ans(r, path + "R"));
            }
        }

        return ""; // 도달할 수 없는 경우 빈 문자열 반환
    }
    public static class Ans {


        int number;
        String ans;

        Ans(int number, String ans) {
            this.number = number;
            this.ans = ans;
        }
    }
}