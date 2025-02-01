import java.io.*;
import java.util.*;

public class Main {
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                int a = Integer.parseInt(st.nextToken());
                add(a);
            } else if (command.equals("remove")) {
                int a = Integer.parseInt(st.nextToken());
                remove(a);
            } else if (command.equals("check")) {
                int a = Integer.parseInt(st.nextToken());
                sb.append(check(a)).append("\n");
            } else if (command.equals("toggle")) {
                int a = Integer.parseInt(st.nextToken());
                toggle(a);
            } else if (command.equals("all")) {
                all();
            } else if (command.equals("empty")) {
                empty();
            }
        }

        System.out.println(sb);
    }

    public static void add(int a) {
        set.add(a);
    }

    public static void remove(int a) {
        set.remove(a);
    }

    public static int check(int a) {
        if (set.contains(a)) {
            return 1;
        }
        else{
            return 0;
        }
    }

    public static void toggle(int a) {
        if (set.contains(a)) {
            set.remove(a);
        }else {
            set.add(a);
        }
    }

    public static void all() {
        for (int i = 1; i < 21; i++) {
            set.add(i);
        }
    }

    public static void empty() {
        set.clear();
    }
}
