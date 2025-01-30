import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] abc = new int[26];
        char[] string = br.readLine().toCharArray();
        for (char alpha : string) {
            abc[alpha - 'a']++;
        }

        for (int ans : abc) {
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
    }


}
