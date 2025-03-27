import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            back(0, "1");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void back(int depth, String string) {

        if (depth == N-1) {
            if (calculate(string) == 0) {
                sb.append(string);
                sb.append("\n");
            }
            return;
        }
        back(depth + 1, string + " " + (depth + 2));
        back(depth + 1, string + "+" + (depth + 2));
        back(depth + 1, string + "-" + (depth + 2));
    }

    static int calculate(String str){
        str = str.replaceAll(" ", "");
        Iterator<Integer> it= Arrays.stream(str.split("[+,-]"))
                .map(Integer::parseInt)
                .collect(toList()).iterator();
        int result = it.next();
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == '+') {
                result += it.next();
            }else if(str.charAt(i) == '-') {
                result -= it.next();
            }
        }
        return result;

    }
}