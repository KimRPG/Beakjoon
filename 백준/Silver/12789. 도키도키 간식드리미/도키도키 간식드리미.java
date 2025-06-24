import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (list.size() + 1 == a) {
                list.add(a);
            }else{
                stack.add(a);
            }
            while (!stack.isEmpty() && list.size() + 1 == stack.peek()) {
                list.add(stack.pop());
            }
        }


        System.out.println(list.size()== N ? "Nice" : "Sad");
    }
}
