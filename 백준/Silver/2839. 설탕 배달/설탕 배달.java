import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 0 || N == 1 || N == 2 || N == 4 || N == 7) {
            System.out.println(-1);
            return;
        }
        int rest;
        if (N % 5 == 0) {
            rest = 0;
        } else if (N % 5 == 1 || N % 5 == 3) {
            rest = 1;
        }else{
            rest = 2;
        }
        System.out.println(N / 5 + rest);
    }
}
