import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String command = st.nextToken();

            if (command.equals("enter")) {
                set.add(name);
            }
            else{
                set.remove(name);
            }
        }
        List<String> tempSet = new ArrayList<>(set);
        tempSet.sort(Comparator.reverseOrder());

        for (String string : tempSet) {
            System.out.println(string);
        }
    }
}
