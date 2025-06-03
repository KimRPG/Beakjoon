import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = test * 78 / 100;
        int b = (test * 80 / 100) + (test * 20 / 100 * 78 / 100);
        sb.append(a).append(" ").append(b);
        System.out.println(sb);
    }
}
