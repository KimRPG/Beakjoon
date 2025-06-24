import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int current = 1;
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (current == a) {
                current++;
            }else{
                stack.add(a);
            }
            while (!stack.isEmpty() && current == stack.peek()) {
                stack.pop();
                current++;
            }
        }


        System.out.println(current == N+1 ? "Nice" : "Sad");
    }
}
