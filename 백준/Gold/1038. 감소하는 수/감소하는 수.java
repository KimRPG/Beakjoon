import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Long> decreasingNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N > 1022) { // 1022보다 큰 경우는 감소하는 수가 존재하지 않음
            System.out.println(-1);
            return;
        }

        // 감소하는 수를 생성
        for (int i = 0; i < 10; i++) {
            generateDecreasingNumbers(i, 1);
        }

        Collections.sort(decreasingNumbers);
        System.out.println(decreasingNumbers.get(N));
    }

    // 감소하는 수를 생성하는 함수
    public static void generateDecreasingNumbers(long num, int depth) {
        decreasingNumbers.add(num);

        for (int i = 0; i < num % 10; i++) {
            generateDecreasingNumbers(num * 10 + i, depth + 1);
        }
    }
}
