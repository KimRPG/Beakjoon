import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int main = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mainSt = "";
        for (int i = 0; i < 7; i++) {
            String[] a = br.readLine().split(" ");
            int b = Integer.parseInt(a[1]);
            if (main < b) {
                main = b;
                mainSt = a[0];
            }
        }
        System.out.println(mainSt);
    }
}
