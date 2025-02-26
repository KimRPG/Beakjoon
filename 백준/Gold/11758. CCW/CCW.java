import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x1 = 0, x2 = 0, x3 = 0;
        int y1 = 0, y2 = 0, y3 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        int ans = (y3 - y1) * (x2 - x1) - (x3 - x1) * (y2 - y1);
        System.out.println(Integer.compare(ans, 0));

    }
}
