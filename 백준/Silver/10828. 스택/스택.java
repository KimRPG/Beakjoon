import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] stack = new int[10001];
        int head = -1;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    head++;
                    stack[head] = num;
                    break;
                case "pop" :
                    if (head != -1) {
                        sb.append(stack[head]).append("\n");
                        head--;
                    }else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "top" :
                    if (head != -1) {
                        sb.append(stack[head]).append("\n");
                    }else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "empty" :
                    if(head==-1) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "size":
                    sb.append(head + 1).append("\n");
            }
        }
        System.out.println(sb);
    }
}
