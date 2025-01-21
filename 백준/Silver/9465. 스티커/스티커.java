class Main {

    public static void main(String[] args) throws Exception {

        int T, N, a, b, c;

        T = read();

        int[][] dp = new int[2][100000];
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            N = read();

            for (int i = 0; i < N; i++) dp[0][i] = read();
            for (int i = 0; i < N; i++) dp[1][i] = read();

            if(N==1){
                sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append('\n');
                continue;
            }

            dp[0][1] += dp[1][0];
            dp[1][1] += dp[0][0];


            for (int i = 2; i < N; i++) {

                c = Math.max(dp[0][i - 2], dp[1][i - 2]);
                a = Math.max(c, dp[1][i - 1]);
                b = Math.max(c, dp[0][i - 1]);

                dp[0][i] += a;
                dp[1][i] += b;

            }

            sb.append(Math.max(dp[0][N - 1], dp[1][N - 1])).append('\n');

        }

        System.out.print(sb);

    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return n;

    }

}
