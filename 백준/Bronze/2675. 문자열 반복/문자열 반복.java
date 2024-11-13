import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            char[] b = st.nextToken().toCharArray();
            for (char c : b){
                sb.append(String.valueOf(c).repeat(Math.max(0, a)));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}