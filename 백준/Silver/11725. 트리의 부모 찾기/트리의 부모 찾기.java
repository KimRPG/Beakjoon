import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 트리 그래프 초기화
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 부모 정보를 저장할 배열 및 방문 배열 초기화
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        // DFS 탐색
        dfs(1);

        // 부모 정보 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int current) {
        visited[current] = true;

        for (int child : tree.get(current)) {
            if (!visited[child]) {
                parent[child] = current; // 부모 기록
                dfs(child); // 자식 노드로 이동
            }
        }
    }
}
