import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> deque;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push_front")){
                int a = Integer.parseInt(st.nextToken());
                push_front(a);
            }
            else if(command.equals("push_back")){
                int a = Integer.parseInt(st.nextToken());
                push_back(a);
            }
            else if(command.equals("pop_front")){
                sb.append(pop_front()).append("\n");
            }
            else if(command.equals("pop_back")){
                sb.append(pop_back()).append("\n");
            }
            else if(command.equals("size")){
                sb.append(size()).append("\n");
            }
            else if(command.equals("empty")){
                sb.append(empty()).append("\n");
            }
            else if(command.equals("front")){
                sb.append(front()).append("\n");
            }
            else if(command.equals("back")){
                sb.append(back()).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void push_front(int a) {
        deque.addFirst(a);
    }
    public static void push_back(int a) {
        deque.addLast(a);
    }

    public static int pop_front() {
        if(deque.isEmpty()) return -1;
        return deque.pollFirst();
    }
    public static int pop_back() {
        if(deque.isEmpty()) return -1;
        return deque.pollLast();
    }

    public static int size() {
        return deque.size();
    }

    public static int empty() {
        if(deque.isEmpty()) return 1;
        else return 0;
    }

    public static int front() {
        if(deque.isEmpty()) return -1;
        return deque.peekFirst();
    }
    public static int back() {
        if(deque.isEmpty()) return -1;
        return deque.peekLast();
    }

}
