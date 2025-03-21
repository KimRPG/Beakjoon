import java.io.*;
import java.util.*;
public class Main{

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        Arrays.sort(a);

        for (int i = a.length - 1; i >= 0; i--) {
            System.out.print(a[i]);
        }
    }

}