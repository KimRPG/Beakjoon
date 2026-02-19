import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = 0;
        int min = 0;
        int[] list = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            list[i] = a;
            max = Math.max(a, max);
        }

        while(min < max) {

            int mid = (min + max) / 2;
            long sum = 0;
            for(int treeHeight : list) {
                if(treeHeight - mid > 0) {
                    sum += (treeHeight - mid);
                }
            }
            if(sum < M) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }

}