import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] number, op;
    static int max=-1_000_000_000, min=1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        number = new int[N];
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        back(1, 0, number[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void back(int start, int depth, int num) {
        if (depth == N-1) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        else{
            for (int i = start; i < N; i++) {
                for (int j = 0; j < 4; j++) {
                    if(op[j] == 0) continue;
                    else{
                        op[j]--;
                        if(j == 0) back(i+1, depth + 1, num + number[i]);
                        if(j == 1) back(i+1, depth + 1, num - number[i]);
                        if(j == 2) back(i+1, depth + 1, num * number[i]);
                        if(j == 3) back(i+1, depth + 1, num / number[i]);
                        op[j]++;
                    }
                }
            }
        }

    }
}