package silver.p1260;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt(); //N개의 노드
        int M = s.nextInt(); //M개의 연결선
        int V = s.nextInt(); //시작 숫자
        s.nextLine();
        int[][] graph = new int[N][M];

        for (int i = 0; i < M; i++) {
            String ans = s.nextLine();
            String[] hi =ans.split(" ");
            int node = Integer.parseInt(hi[0]);
            int arv = Integer.parseInt(hi[1]);

        }

    }
}
