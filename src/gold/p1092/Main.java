package gold.p1092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static Integer Macro(String st) {
        return Integer.parseInt(st);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Macro(br.readLine());// 크레인 수
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Macro(st.nextToken());
        }
        int M = Macro(br.readLine()); // 옮길 물건의 수
        Integer[] things = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            things[i] = Macro(st.nextToken());
        }
        Arrays.sort(cranes, Comparator.reverseOrder());
        Arrays.sort(things, Comparator.reverseOrder());
        int recent = 0;
        int ans = 0;
        boolean[] used = new boolean[M];
        if (things[0] > cranes[0]) {
            System.out.println("-1");
        } else {
            while (recent < M) {
                int thingIndex = 0;
                for (int i = 0; i < N; i++) {
                    while (thingIndex < M) {
                        // 사용되지 않은 물건 중에서 옮길 수 있는 것을 찾음
                        if (!used[thingIndex] && cranes[i] >= things[thingIndex]) {
                            used[thingIndex] = true; // 물건을 사용 처리
                            recent++; // 옮겨진 물건 수 증가
                            break; // 다음 크레인으로 이동
                        }
                        thingIndex++;
                    }
                }
                ans++;
            }
            System.out.println(ans);
        }
    }
}


