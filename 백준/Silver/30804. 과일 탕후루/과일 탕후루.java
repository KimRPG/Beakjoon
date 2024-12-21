import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] tangHooRoo = new int[N];

        // 입력값 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tangHooRoo[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001]; // 숫자의 범위는 문제에 따라 조정 필요
        int maxLength = 0;
        int uniqueCount = 0; // 현재 윈도우 내 고유 숫자 개수

        int left = 0;
        for (int right = 0; right < N; right++) {
            // 오른쪽 포인터 확장
            if (count[tangHooRoo[right]] == 0) {
                uniqueCount++;
            }
            count[tangHooRoo[right]]++;

            // 고유 숫자가 2개를 초과하면 왼쪽 포인터 이동
            while (uniqueCount > 2) {
                count[tangHooRoo[left]]--;
                if (count[tangHooRoo[left]] == 0) {
                    uniqueCount--;
                }
                left++;
            }

            // 현재 윈도우 길이를 계산하여 최대값 갱신
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}