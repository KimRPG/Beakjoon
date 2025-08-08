import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split(" ");
            String a = st[0];
            String b = st[1];
            sb.append(a).append(" & ").append(b);
            if (isAnagram(a, b)) {
                sb.append(" are anagrams.");
            }else{
                sb.append(" are NOT anagrams.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isAnagram(String a, String b) {
        int[] alpha = new int[26];
        for (char c : a.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            alpha[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if(alpha[i] != 0) return false;
        }
        return true;

    }
}