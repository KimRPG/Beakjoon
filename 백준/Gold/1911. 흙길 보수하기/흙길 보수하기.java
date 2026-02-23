import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }
        int cur = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] water = pq.poll();
            if (water[1] <= cur) {
                continue;
            }
            if(water[0] > cur){
                cur = water[0];
            }
            int need = 0;
            if ((water[1] - cur) % L == 0) {
                need = (water[1] - cur) / L;
            }else{
                need = ((water[1] - cur) / L) + 1;
            }
            cur += need * L;
            ans += need;
            
        }
        System.out.println(ans);
    }
}