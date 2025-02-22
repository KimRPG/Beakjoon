import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        long a = 0;
        for (String st : strings) {
            a += Long.parseLong(st);
        }
        System.out.println(a);
    }
}
