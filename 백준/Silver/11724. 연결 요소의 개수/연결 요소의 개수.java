import java.util.*;

class Main {
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 47) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
    
    public static void main(String[] args) throws Exception {
        int n = read();
        int m = read();
        int[] un = new int[n + 1];
        for (int i = 1; i <= n; i++) un[i] = i;
        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            union(un, a, b);
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(find(un, i));
        }
        System.out.println(set.size());
    }
    
    static void union(int[] un, int a, int b) {
        int fa = find(un, a);
        int fb = find(un, b);
        if (fa != fb) un[fa] = fb;
    }
    
    static int find(int[] un, int a) {
        if (a == un[a]) return a;
        return un[a] = find(un, un[a]);
    }
}