import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr,Comparator.reverseOrder());
        for(int i = 0 ; i<M;i++){
            pq.add(0);
        }

        for(int i = 0; i<N;i++){
            pq.add(pq.poll()+arr[i]);
        }
        int max = 0;
        while(!pq.isEmpty()){
            max = Math.max(pq.poll(),max);
        }
        System.out.println(max);

    }
}