import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            String[] words = new String[n];
            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            // 사전순 정렬 (대소문자 구분 없이)
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareToIgnoreCase(o2);
                }
            });

            // 가장 앞선 단어 출력
            System.out.println(words[0]);
        }

        sc.close();
    }
}
