import jdk.dynalink.beans.StaticClass;

import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long max = 0;
        long min = 1_000_001;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(st.nextToken());
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        System.out.println(max * min);
    }
}