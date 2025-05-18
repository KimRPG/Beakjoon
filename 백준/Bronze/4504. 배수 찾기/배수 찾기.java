import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a = Integer.parseInt(br.readLine());
            if(a==0) break;
            if (a % N == 0) {
                sb.append(a).append(" is a multiple of ").append(N).append(".").append("\n");
            }else {
                sb.append(a).append(" is NOT a multiple of ").append(N).append(".").append("\n");
            }
        }
        System.out.println(sb);
    }
}