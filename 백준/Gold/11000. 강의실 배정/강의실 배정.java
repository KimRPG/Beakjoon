import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        PriorityQueue<Integer> endQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }
        int max = 0;

        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            if(endQueue.isEmpty()){
                endQueue.add(a[1]);
            }else{
                while (!endQueue.isEmpty()) {
                    int endTime = endQueue.peek();
                    if (endTime <= a[0]) {
                        endQueue.poll();
                    } else {
                        endQueue.add(a[1]);
                        max = Math.max(max, endQueue.size());
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }
}