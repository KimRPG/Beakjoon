import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // LinkedList 생성 및 초기 문자열 입력
        LinkedList<Character> list = new LinkedList<>();
        String input = br.readLine();
        for (char ch : input.toCharArray()) {
            list.add(ch);
        }

        // ListIterator 생성 (초기 위치는 맨 뒤)
        ListIterator<Character> cursor = list.listIterator(list.size());

        // 명령어 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 명령어 처리
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("P")) {
                char ch = st.nextToken().charAt(0);
                cursor.add(ch); // 커서 위치에 문자 삽입 (O(1))
            } else if (command.equals("L")) {
                if (cursor.hasPrevious()) {
                    cursor.previous(); // 왼쪽 이동
                }
            } else if (command.equals("D")) {
                if (cursor.hasNext()) {
                    cursor.next(); // 오른쪽 이동
                }
            } else if (command.equals("B")) {
                if (cursor.hasPrevious()) {
                    cursor.previous(); // 왼쪽 이동 후 삭제
                    cursor.remove();  // (O(1))
                }
            }
        }

        // 결과 출력
        for (char ch : list) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
