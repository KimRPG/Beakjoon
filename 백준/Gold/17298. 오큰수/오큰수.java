import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && ans[stack.peek()] < ans[i]) {
                ans[stack.pop()] = ans[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        for(int i = 0; i<N; i++)
            sb.append(ans[i]).append(" ");

        System.out.println(sb);

    }
}

