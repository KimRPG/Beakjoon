import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[N][N];
        int[][] dp = new int[N][N];

        // 삼각형 배열 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) { // `j <= i`로 변경
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 설정
        dp[0][0] = arr[0][0];
        if (N == 1) {
            System.out.println(dp[0][0]);
            return;
        }

        // DP 테이블 채우기
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + arr[i][j]; // 왼쪽 끝
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j]; // 오른쪽 끝
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j]; // 중간
                }
            }
        }

        // 마지막 줄에서 최댓값 찾기
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, dp[N - 1][i]);
        }
        System.out.println(ans);
    }
}
