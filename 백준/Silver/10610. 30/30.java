import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();
        int[] num = new int[10];
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (char c : ch) {
            num[c - '0']++;
            sum += c;
        }

        if (num[0] == 0 || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        int i = 9;
        while (i != -1) {

            while (num[i] != 0) {
                sb.append(i);
                num[i]--;
            }
            i--;
        }
        System.out.println(sb);
    }
}