import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 게이트의 수 G
        int G = Integer.parseInt(br.readLine());
        // 비행기의 수 P
        int P = Integer.parseInt(br.readLine());

        // Union-Find를 위한 parent 배열 초기화
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());
            
            // gi 이하에서 도킹 가능한 가장 큰 번호의 게이트를 찾음
            int availableGate = find(gi);

            // 도킹 가능한 게이트가 0이라면 더 이상 도킹 불가
            if (availableGate == 0) {
                break;
            }

            // 도킹 성공: 해당 게이트를 왼쪽 게이트(availableGate - 1)와 합침
            union(availableGate, availableGate - 1);
            count++;
        }

        System.out.println(count);
    }

    // Path Compression(경로 압축)을 적용한 find 연산
    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // 두 집합을 합치는 union 연산 (여기서는 항상 작은 쪽으로 합쳐지도록 설계)
    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[x] = y;
        }
    }
}