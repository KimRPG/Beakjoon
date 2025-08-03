import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = 0;
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        time = h * 60 * 60 + m * 60 + s + t;
        s = time % 60;
        time /= 60;
        m = time % 60;
        time /= 60;
        h = time % 24;

        System.out.println(h + " " + m + " " + s);
    }
}