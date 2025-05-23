import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private int[] getCntArr(String s) {
        int[] cnt = new int['z'-'a'+1];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        return cnt;
    }
    private void solution() throws Exception  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String a = br.readLine();
            if (a == null) break;
            String b = br.readLine();

            int[] cntA = getCntArr(a);
            int[] cntB = getCntArr(b);

            for (int i = 0; i < cntA.length; i++) {
                sb.append(String.valueOf((char) ('a' + i)).repeat(Math.max(0, Math.min(cntA[i], cntB[i]))));
            }
            sb.append('\n');
        }
        System.out.print(sb);
        }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
