import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (N >= M) {
            System.out.println(2 * N - M);
        }else {
            System.out.println(2 * M - N);
        }

    }

}