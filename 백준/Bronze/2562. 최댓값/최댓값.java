import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        int max = Collections.max(list);
        System.out.println(max);
        System.out.println(list.indexOf(max)+1);
    }
}