import java.util.*;

public class Main {

    static int n, ans = 0;
    static List<Integer> v = new ArrayList<>();
    static int[] op;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            v.add(sc.nextInt());
        }

        op = new int[n];
        used = new boolean[n];

        go(0);

        System.out.println(ans / 2); // 같은 경우가 2번 카운팅되므로 절반
    }

    static void go(int k) {
        if (k == n) {
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                int sum = 0;
                int pos = i;

                while (true) {
                    sum += op[pos];
                    pos = (pos + 1) % n;

                    if (sum == 50) {
                        cnt++;
                        break;
                    }

                    if (sum > 50) {
                        break;
                    }
                }
            }

            ans = Math.max(ans, cnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                used[i] = true;
                op[k] = v.get(i);
                go(k + 1);
                used[i] = false;
            }
        }
    }
}
