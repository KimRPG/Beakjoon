import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int T = Integer.parseInt(st[1]);
        int[][] DP = new int[N + 1][T + 1];
        int[][] money = new int[N][2];
        int total = 0;
        for(int i = 0; i < N; i++){
            st = br.readLine().split(" ");
            money[i][0]= Integer.parseInt(st[0]);
            money[i][1]= Integer.parseInt(st[1]);
            total += Integer.parseInt(st[1]);
        }

        for(int i = 1; i < N+1; i++){
            int[] now = money[i-1];
            for(int j = 1; j < T+1; j++){
                if (j - now[0] >= 0) {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i-1][j - now[0]]+ now[1]);
                }
                else{
                    DP[i][j] = DP[i - 1][j];
                }
            }
        }

        System.out.println(total-DP[N][T]);
    }

}