import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[][] points = new double[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());
        }

        double area = 0;
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;
            area += (points[i][0] * points[j][1]) - (points[j][0] * points[i][1]);
        }

        System.out.printf("%.1f\n", Math.abs(area) / 2.0);
    }
}
