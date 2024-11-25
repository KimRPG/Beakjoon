import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine(); // 입력을 문자열로 읽음
            if (input.equals("0")) break; // 종료 조건 체크

            char[] a = input.toCharArray(); // 입력을 문자 배열로 변환
            String ans = "yes";
            for (int i = 0; i < a.length / 2; i++) {
                if (a[i] != a[a.length - 1 - i]) { // 회문 체크
                    ans = "no";
                    break;
                }
            }
            sb.append(ans).append("\n"); // 결과를 StringBuilder에 추가
        }

        System.out.print(sb); // 결과 출력
    }
}
