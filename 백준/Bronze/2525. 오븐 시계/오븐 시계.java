import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int total = Integer.parseInt(br.readLine());
        int tHour = total / 60;
        int tMinute = total % 60;
        minute += tMinute;
        if (minute >= 60) {
            hour++;
            minute %= 60;
        }
        hour = (hour + tHour) % 24;


        sb.append(hour).append(" ").append(minute);
        System.out.println(sb);
    }

}

