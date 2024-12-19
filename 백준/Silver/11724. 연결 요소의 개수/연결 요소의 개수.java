import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        }
        for (int i = 0; i < N; i++) {
            set.add(find(i));
        }

        System.out.println(set.size());

    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static int find(int xy) {
        if (parent[xy] == xy) {
            return xy;
        }
        return parent[xy] = find(parent[xy]); // 경로 압축
    }
}
