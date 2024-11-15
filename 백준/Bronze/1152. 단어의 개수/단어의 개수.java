import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = 0;
        while (st.hasMoreTokens()){
            st.nextToken();
            a++;
        }
        System.out.println(a);
    }
}