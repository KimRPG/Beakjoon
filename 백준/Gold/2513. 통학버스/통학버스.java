import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int Macro(String st) {
        return Integer.parseInt(st);
    }

    static int K;
    static int s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Macro(st.nextToken()); //아파트 단지 수
        K = Macro(st.nextToken()); //통학버스 정원
        s = Macro(st.nextToken()); // 학교 위치
        PriorityQueue<int[]> big = new PriorityQueue<>((o1, o2) -> Integer.compare(Math.abs(o2[0] - s), Math.abs(o1[0] - s)));
        PriorityQueue<int[]> small = new PriorityQueue<>((o1, o2) -> Integer.compare(Math.abs(o2[0] - s), Math.abs(o1[0] - s)));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int loc = Macro(st.nextToken());
            int stu_num = Macro(st.nextToken());
            int[] arr = new int[2];
            arr[0]=loc;
            arr[1]=stu_num;
            if (loc - s > 0) {
                big.offer(arr);
            }else {
                small.offer(arr);
            }
        }
        System.out.println(distance(big) + distance(small));


    }

    static int distance(PriorityQueue<int[]> pq) {
        int distance = 0;
        while (!pq.isEmpty()) {
            int p = K;
            while (p > 0) {
                if (p == K) {
                    distance += Math.abs(pq.peek()[0]-s);
                }
                p -= pq.peek()[1];
                if (p < 0) {
                    pq.peek()[1] = Math.abs(p);
                }
                else{
                    pq.poll();
                    if (pq.isEmpty()) {
                        break;
                    }
                }

            }

        }
        return distance*2;
    }
}
