import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        long N = Integer.parseInt(st[0]);
        long M = Integer.parseInt(st[1]);
        System.out.println(Math.abs(N - M));
    }
}
