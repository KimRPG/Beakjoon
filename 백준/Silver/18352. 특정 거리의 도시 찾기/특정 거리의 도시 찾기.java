    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.util.*;

    public class Main {
        static StringBuilder sb = new StringBuilder();
        static boolean[] visit;
        static int N,M,K,X;
        static ArrayList<Integer>[] arr;

        static PriorityQueue<Integer> pq = new PriorityQueue<>();
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 도시의 개수
            M = Integer.parseInt(st.nextToken()); // 도로의 개수
            K = Integer.parseInt(st.nextToken()); // 거리 정보
            X = Integer.parseInt(st.nextToken()); // 출발 도시의 정보

            arr = new ArrayList[N];// 도로 정보
            visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                arr[start].add(end);
            }
            BFS(X - 1);
            if (pq.isEmpty()) {
                System.out.println(-1);
            } else {
                while (!pq.isEmpty()) {
                    sb.append(pq.poll()).append("\n");
                }
                System.out.println(sb);
            }
        }

        public static void BFS(int start) {
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{start, 0});//시작과 depth
            visit[start] = true;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int point = now[0];
                int depth = now[1];
                if (depth == K) {
                    pq.add(point + 1);
                } else if (depth < K) {
                    for (int a : arr[point]) {
                        if (!visit[a]) {
                            queue.add(new int[]{a, depth + 1});
                            visit[a] = true;
                        }
                    }
                }
            }
        }
    }
