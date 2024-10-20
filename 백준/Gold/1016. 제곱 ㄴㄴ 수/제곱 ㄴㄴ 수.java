import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        long count = max-min+1;
        boolean[] arr = new boolean[(int)count];

        int answer = 0;
        for (long num = 2; num <= (int)Math.sqrt(max); num++) {
            long squareNumber = num*num;
            //System.out.printf("squareNumber: %d ", squareNumber);

            long start = min%squareNumber == 0 ? min/squareNumber : (min/squareNumber)+1;
            //System.out.printf("start: %d ", start);

            for (long j = start; squareNumber*j <= max; j++) {
                int index = (int)(squareNumber*j-min);

                if (arr[index]) continue;
                else {
                    arr[index] = true;
                    answer++;
                }
            }
        }
        System.out.println(count-answer);
    }
}