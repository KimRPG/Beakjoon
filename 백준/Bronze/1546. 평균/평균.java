import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Float> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Float.parseFloat(st.nextToken()));
        }
        float max = Collections.max(list);
        float sum = 0;
        for (float a : list) {
            a = a / max * 100;
            sum += a;
        }
        System.out.println(sum / N);
    }
}