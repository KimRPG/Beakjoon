import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int g = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        String W = br.readLine();
        String S = br.readLine();

        // W와 현재 윈도우의 알파벳 개수를 저장할 배열
        // 'A'~'Z'는 0~25, 'a'~'z'는 26~51 인덱스에 매핑
        int[] wCount = new int[52];
        int[] sCount = new int[52];

        // 1. 기준 배열(wCount) 생성
        for (char ch : W.toCharArray()) {
            wCount[getCharIndex(ch)]++;
        }

        int answer = 0;
        int windowStart = 0;

        // 2. 초기 윈도우(sCount) 설정 및 슬라이딩 시작
        for (int windowEnd = 0; windowEnd < s; windowEnd++) {
            // 윈도우에 새로운 문자 추가
            char newChar = S.charAt(windowEnd);
            sCount[getCharIndex(newChar)]++;

            // 윈도우 크기가 g와 같아지면 비교 시작
            if (windowEnd - windowStart + 1 == g) {
                // 3. W의 구성과 현재 윈도우의 구성이 같은지 확인
                if (Arrays.equals(wCount, sCount)) {
                    answer++;
                }

                // 4. 윈도우를 이동시키기 위해 맨 왼쪽 문자 제거
                char oldChar = S.charAt(windowStart);
                sCount[getCharIndex(oldChar)]--;
                windowStart++; // 윈도우 시작점 이동
            }
        }

        System.out.println(answer);
    }

    // 문자를 배열 인덱스(0~51)로 변환하는 헬퍼 메소드
    private static int getCharIndex(char c) {
        if (c >= 'A' && c <= 'Z') {
            return c - 'A'; // 'A'~'Z' -> 0~25
        } else { // c >= 'a' && c <= 'z'
            return c - 'a' + 26; // 'a'~'z' -> 26~51
        }
    }
}