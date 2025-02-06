import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] command = br.readLine().toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < command.length / 2; i++) {
            a += command[i] - '0';
        }
        for (int i = command.length / 2; i < command.length; i++) {
            b += command[i] - '0';
        }

        if (a == b) {
            System.out.println("LUCKY");
        }
        else{
            System.out.println("READY");
        }
    }
}
