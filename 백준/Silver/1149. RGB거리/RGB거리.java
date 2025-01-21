import java.io.*;
import java.util.*;

public class Main {

    static int[][] RGB;

    static int[][] dynamic;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        RGB = new int[N][3];
        dynamic = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            RGB[i][0] = Integer.parseInt(st.nextToken());
            RGB[i][1] = Integer.parseInt(st.nextToken());
            RGB[i][2] = Integer.parseInt(st.nextToken());
        }
        dynamic[0][0] = RGB[0][0];
        dynamic[0][1] = RGB[0][1];
        dynamic[0][2] = RGB[0][2];
        int result = Math.min(DP(N - 1, 0), Math.min(DP(N - 1, 1), DP(N - 1, 2)));
        System.out.println(result);

    }
    public static int DP(int index, int color) {
        if (dynamic[index][color] != 0) {
            return dynamic[index][color];
        }
        else{
            int a;
            if (color == 1) {
                a = Math.min(DP(index-1, 2) + RGB[index][1], DP(index-1, 0) + RGB[index][1]);
                dynamic[index][color] = a;
                return a;
            } else if (color == 2) {
                a = Math.min(DP(index-1, 1) + RGB[index][2], DP(index-1, 0) + RGB[index][2]);
                dynamic[index][color] = a;
                return a;
            }else {
                a = Math.min(DP(index-1, 2) + RGB[index][0], DP(index-1, 1) + RGB[index][0]);
                dynamic[index][color] = a;
                return a;
            }
        }
    }

    
    
}

