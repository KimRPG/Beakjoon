import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hi = br.readLine();
        char start = 'a';
        for (int i = 0; i < 26; i++) {
            System.out.print(hi.indexOf((char)(start+i))+" ");
        }
    }
}