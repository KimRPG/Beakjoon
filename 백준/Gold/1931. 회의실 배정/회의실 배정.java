import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->
        {
            int a = x[1];
            int b = y[1];
            if(a==b) return x[0] - y[0];
            return x[1] - y[1];
        }
                );
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] a = new int[2];
            a[0] = Integer.parseInt(st.nextToken());
            a[1] = Integer.parseInt(st.nextToken());
            pq.add(a);
        }
        int endTime = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            int[] time = pq.poll();
            if(endTime <= time[0]) {
                endTime = time[1];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
