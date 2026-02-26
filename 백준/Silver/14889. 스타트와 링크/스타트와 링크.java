import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] isVisit;
    static int[][] arr;
    static int[] teamA, teamB;
    static int min= 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        teamA = new int[N/2];
        teamB = new int[N/2];
        isVisit = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        back(0, 0);
        System.out.println(min);

    }

    public static void back(int n, int turn){
        if(turn >= N/2){
            minScore();
            return;
        }
        for (int i = n; i < N; i++) {
            if(!isVisit[i]){
                isVisit[i] = true;
                back(i, turn+1);
                isVisit[i] = false;
            }
        }
    }

    public static void minScore(){
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i와 j가 모두 방문(true)이면 A팀
                if (isVisit[i] && isVisit[j]) {
                    teamA += arr[i][j];
                    teamA += arr[j][i];
                }
                // i와 j가 모두 미방문(false)이면 B팀
                else if (!isVisit[i] && !isVisit[j]) {
                    teamB += arr[i][j];
                    teamB += arr[j][i];
                }
            }
        }

        int val = Math.abs(teamA - teamB);

        // 차이가 0이면 더 이상 최솟값이 나올 수 없으므로 바로 종료 가능 (선택사항)
        if (val == 0) {
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(val, min);
    }
}