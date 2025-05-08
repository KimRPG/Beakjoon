import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<string.length(); i++){
            for(int j=i+1; j<=string.length(); j++){
                set.add(string.substring(i, j));
            }
        }

        System.out.println(set.size());

    }
}