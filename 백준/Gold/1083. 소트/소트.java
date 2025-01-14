import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int S = Integer.parseInt(br.readLine());
        int a = 0;

        while (S > 0 && a < N - 1) { // 정지 조건 수정
            int maxIndex = a;
            int maxValue = arr.get(a);

            // 탐색 범위: a부터 a + S 또는 끝까지
            for (int i = a + 1; i < N && i <= a + S; i++) {
                if (arr.get(i) > maxValue) {
                    maxValue = arr.get(i);
                    maxIndex = i;
                }
            }

            // 최대값이 이미 맨 앞이면 이동하지 않음
            if (maxIndex == a) {
                a++;
                continue;
            }

            // 최대값을 맨 앞으로 이동
            arr.remove(maxIndex);
            arr.add(a, maxValue);

            // S 감소 (최대값 이동에 사용한 거리)
            S -= (maxIndex - a);
            a++;
        }

        // 결과 출력
        for (Integer integer : arr) {
            System.out.print(integer + " ");
        }
    }
}
