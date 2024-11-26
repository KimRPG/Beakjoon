import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int bestSum=0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int currentSum = array[i] + array[j] + array[k];

                    // 합이 M을 넘지 않는 경우 최적값 갱신
                    if (currentSum <= M && currentSum > bestSum) {
                        bestSum = currentSum;
                    }

                    // M에 도달하면 즉시 종료
                    if (bestSum == M) {
                        System.out.println(bestSum);
                        return;
                    }
                }
            }
        }
        System.out.println(bestSum);
        
    }
}
