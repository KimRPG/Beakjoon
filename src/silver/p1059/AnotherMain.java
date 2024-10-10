package silver.p1059;

import java.io.*;
import java.util.StringTokenizer;

public class AnotherMain {
    static int Macro(String str) {
        return Integer.parseInt(str);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int setLength = Macro(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Macro(br.readLine());
        int min =0 , max = 1000;

        for (int i = 0; i < setLength; i++) {
            int r = Macro(st.nextToken());
            if(n<r) max = Math.min(max, r);
            else if(n>r) max = Math.max(min, r);
            else {
                bw.write("0");
                bw.close();
                return;
            }
        }
//    }

        System.out.println("13".compareTo("3"));

    }
}
