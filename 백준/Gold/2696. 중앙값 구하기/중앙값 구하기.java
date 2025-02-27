import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            sb.append((M+1)/2);
            sb.append("\n");
            PriorityQueue<Integer> minPQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>();

            int cnt = 0;
            for(int i=0;i<M;i++){
                if(i%10==0) st = new StringTokenizer(br.readLine());
                int var = Integer.parseInt(st.nextToken());

                if(minPQ.size() == maxPQ.size()) maxPQ.add(var);
                else minPQ.add(var);

                if(!minPQ.isEmpty() && !maxPQ.isEmpty()){
                    if(minPQ.peek() > maxPQ.peek()){
                        int tmp = maxPQ.poll();
                        maxPQ.add(minPQ.poll());
                        minPQ.add(tmp);
                    }
                }

                if(i%2==0){
                    sb.append(maxPQ.peek());
                    sb.append(" ");

                    cnt++;

                    if(cnt%10==0) sb.append("\n");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}