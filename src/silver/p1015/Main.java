package silver.p1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    static Integer Macro(String st) {
        return Integer.parseInt(st);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Macro(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> sortedList = new ArrayList<>();
        int[] duple = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Macro(st.nextToken());
            list.add(a);
            sortedList.add(a);
        }
        sortedList.sort(Comparator.naturalOrder());
        int index = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer i : list) {
            int answer = sortedList.indexOf(i);
                ans.add(answer + duple[i]);
                duple[i]++;
        }
        for (int result : ans) {
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }
}
