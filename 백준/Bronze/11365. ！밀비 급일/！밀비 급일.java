import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb;
        while (true) {
            String st = br.readLine();
            if (st.equals("END")) {
                break;
            }
            sb = new StringBuffer(st);
            System.out.println(sb.reverse());
        }

    }
}