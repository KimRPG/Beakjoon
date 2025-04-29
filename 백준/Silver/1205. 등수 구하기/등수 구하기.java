import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] score = new int[P];
        if(N>0) {
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        if(P==N && score[0]>=point){
            System.out.println(-1);
            return;
        }

        int cnt = 1;
        for(int i=P-1;i>=Math.max(0,P-N-1);i--){
            if(score[i]>point) cnt++;
            else break;
        }
        System.out.println(cnt);
    }
}
