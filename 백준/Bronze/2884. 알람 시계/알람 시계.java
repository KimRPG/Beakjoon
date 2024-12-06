import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        if (minute - 45 < 0) {
            minute += 15;
            hour--;
        }else {
            minute -= 45;
        }

        if (hour < 0) {
            sb.append(23).append(" ").append(minute);
        }else {
            sb.append(hour).append(" ").append(minute);
        }
        System.out.println(sb);
    }


}
