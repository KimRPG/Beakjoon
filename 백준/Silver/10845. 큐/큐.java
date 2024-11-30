import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int start = 0;
        int end = 0;
        int[] queue = new int[10001];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    queue[end++] = num;
                    break;
                case "pop" :
                    if (start - end != 0) sb.append(queue[start++]).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":
                    sb.append(end - start).append("\n");
                    break;
                case "empty":
                    if (start - end == 0) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front" :
                    if(start-end == 0) sb.append(-1).append("\n");
                    else sb.append(queue[start]).append("\n");
                    break;
                case "back" :
                    if(start-end == 0) sb.append(-1).append("\n");
                    else sb.append(queue[end-1]).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
