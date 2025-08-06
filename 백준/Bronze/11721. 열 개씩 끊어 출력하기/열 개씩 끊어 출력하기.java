import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (i % 10 == 0 && i != 0) {

                sb.append("\n");
            }
            sb.append(ch[i]);
        }
        System.out.println(sb);
    }
}