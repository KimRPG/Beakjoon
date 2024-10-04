package silver.p1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] aToZ = countCharacters(br.readLine());

        int oddCount = palindrome(aToZ);

        if (oddCount >= 2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder leftHalf = new StringBuilder();
        String middle = "";

        for (int i = 0; i < aToZ.length; i++) {
            char character = (char) (i + 'A');

            for (int j = 0; j < aToZ[i] / 2; j++) {
                leftHalf.append(character);
            }

            if (aToZ[i] % 2 != 0) {
                middle = String.valueOf(character);
            }
        }

        sb.append(leftHalf);
        sb.append(middle);
        sb.append(leftHalf.reverse());

        System.out.println(sb.toString());
    }

    // 문자열에서 'A'부터 'Z'까지 문자를 세는 메서드
    public static int[] countCharacters(String input) {
        int[] count = new int[26];
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                count[c - 'A']++;
            }
        }
        return count;
    }

    // aToZ 배열에서 홀수 개수의 문자가 몇 개 있는지 세는 메서드
    public static int palindrome(int[] aToZ) {
        return (int) IntStream.of(aToZ)
                .filter(count -> count % 2 != 0) // 홀수인 값 필터링
                .count(); // 필터링된 요소 개수 세기
    }
}
