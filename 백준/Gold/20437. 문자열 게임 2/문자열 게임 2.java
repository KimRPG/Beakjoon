import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String st = br.readLine();
            int N = Integer.parseInt(br.readLine());
            int[] alpha = new int[26];//알파벳 별 개수를 저장한다.

            if(N == 1) { //k가 1일때
                sb.append("1 1\n");
                continue;
            }
            for(int j = 0; j < st.length(); j++) {
                alpha[st.charAt(j) - 'a']++;
            }
            char[] chars = st.toCharArray();
            int max = -1;
            int min = Integer.MAX_VALUE;
            for(int j = 0 ; j < st.length() ; j++){
                if(alpha[st.charAt(j) - 'a'] < N) continue;
                int count = 1;
                for(int k = j+1; k< st.length(); k++){
                    if(chars[j]  == chars[k]) count++;
                    if (count == N) {
                        min = Math.min(min, k - j + 1);
                        max = Math.max(max, k - j + 1);
                        break;}

                }
            }
            if(min == Integer.MAX_VALUE || max == -1) sb.append(-1).append("\n");
            else sb.append(min).append(" ").append(max).append("\n");

        }
        System.out.println(sb);
    }

}

