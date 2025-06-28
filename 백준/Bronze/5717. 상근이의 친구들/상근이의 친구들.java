import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] a = br.readLine().split(" ");
            int b = Integer.parseInt(a[0]);
            int c = Integer.parseInt(a[1]);
            if (b + c == 0) {
                break;
            }
            sb.append(b + c).append("\n");
        }
        System.out.println(sb);
    }

}