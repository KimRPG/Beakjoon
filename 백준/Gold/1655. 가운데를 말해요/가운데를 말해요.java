import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        minHeap.add(Integer.parseInt(br.readLine()));
        sb.append(minHeap.peek()).append("\n");
        maxHeap.add(Integer.parseInt(br.readLine()));
        int a = maxHeap.poll();
        int b = minHeap.poll();
        if (a < b) {
            maxHeap.add(a);
            minHeap.add(b);
        }else{
            maxHeap.add(b);
            minHeap.add(a);
        }
        sb.append(maxHeap.peek()).append("\n");
        for (int i = 2; i < N; i++) {
            if (i % 2 == 0) {
                maxHeap.add(Integer.parseInt(br.readLine()));
            }else{
                minHeap.add(Integer.parseInt(br.readLine()));
            }
            a = maxHeap.poll();
            b = minHeap.poll();
            if (a < b) {
                maxHeap.add(a);
                minHeap.add(b);
            }else{
                maxHeap.add(b);
                minHeap.add(a);
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
