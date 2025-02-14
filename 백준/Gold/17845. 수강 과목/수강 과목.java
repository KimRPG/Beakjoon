    import java.io.*;
    import java.util.*;
    
    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int limit = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] graph = new int[limit + 1];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                for (int j = limit; j >= time; j--) {
                    graph[j] = Math.max(graph[j], graph[j - time] + value);
                }
            }
            System.out.println(graph[limit]);
        }
    
    }
