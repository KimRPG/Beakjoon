import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 바구니의 개수, M: 연산의 횟수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 바구니를 나타낼 배열 선언
        int[] baskets = new int[n];

        // 1. 초기 상태 설정: 각 바구니에 자신의 번호 넣기
        for (int i = 0; i < n; i++) {
            baskets[i] = i + 1; // 0번 인덱스에 1, 1번 인덱스에 2, ...
        }

        // 2. M번의 연산 수행
        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            // i, j 입력 (1-based index)
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            // 배열 인덱스에 맞게 0-based index로 변환
            int start = i - 1;
            int end = j - 1;

            // 3. 투 포인터를 이용해 배열 구간 뒤집기
            while (start < end) {
                // 값 교환(swap)
                int temp = baskets[start];
                baskets[start] = baskets[end];
                baskets[end] = temp;

                // 포인터 이동
                start++;
                end--;
            }
        }

        // 4. 최종 결과 출력
        // StringBuilder를 사용해 효율적으로 문자열을 만든 후 한 번에 출력
        StringBuilder sb = new StringBuilder();
        for (int basket : baskets) {
            sb.append(basket).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}