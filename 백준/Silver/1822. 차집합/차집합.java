import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int a = read();
        int b =read();
        for (int i = 0; i < a; i++) {
            treeMap.put(read(), 0);

        }
        for (int i = 0; i < b; i++) {
            treeMap.remove(read());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(treeMap.size()).append("\n");
        for (int key : treeMap.keySet()) {
            sb.append(key).append(" ");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {

        int c, n = System.in.read() & 15;

        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);

        return n;

    }
}