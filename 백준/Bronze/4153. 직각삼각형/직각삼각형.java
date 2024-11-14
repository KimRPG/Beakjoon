import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int temp;
            if(A+B+C == 0) break;

            if (A > B) { temp = A; A = B; B = temp; }
            if (A > C) { temp = A; A = C; C = temp; }
            if (B > C) { temp = B; B = C; C = temp; }
            if(C*C == (A*A)+(B*B)) sb.append("right\n");
            else sb.append("wrong\n");

        }
        System.out.println(sb);
    }
}