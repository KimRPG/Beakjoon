import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<testCase;i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int notSum = a+b;
            if(notSum != 1){
                notSum = 1;
            }else {
                notSum = 2;
            }
            sb.append(notSum).append("\n");
        }
        sb.setLength(sb.length()-1);
        System.out.print(sb);
    }
}