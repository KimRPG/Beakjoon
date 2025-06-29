import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int ans = 0;
        Queue<Integer> bridge = new ArrayDeque<>();
        Queue<Integer> truck = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int time = 0;
        int weightOnBridge = 0;
        while (!bridge.isEmpty()) {
            time++;
            weightOnBridge -= bridge.poll();
            if(truck.isEmpty()) {
                continue;
            }
            if (truck.peek() + weightOnBridge <= L) {
                int cur = truck.poll();
                weightOnBridge += cur;
                bridge.add(cur);
            }else {
                bridge.add(0);
            }
        }
        System.out.println(time);

    }
}
