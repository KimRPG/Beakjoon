import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] a = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int sum=0;
        int left=0;
        int right=0;
        int ans = 0;

        while(right <= n) {
            if(sum >= s) {
                sum -= a[left++];
            }else {
                sum += a[right++];
            }
            if(sum == s) ans++;
        }

        System.out.println(ans);

    }
}