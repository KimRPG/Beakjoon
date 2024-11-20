package gold.p1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static Integer Macro(String string) {
        return Integer.parseInt(string);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Macro(st.nextToken()); // 멀티탭 구멍 수
        int K = Macro(st.nextToken()); // 전기용품 사용횟수
        int[] sequence = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sequence[i] = Macro(st.nextToken());
        }

        ArrayList<Integer> multiTap = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < K; i++) {
            if (multiTap.contains(sequence[i])) {
                // 이미 멀티탭에 꽂혀있으면 넘어감
                continue;
            }

            if (multiTap.size() < N) {
                // 멀티탭에 빈 자리가 있으면 추가
                multiTap.add(sequence[i]);
            } else {
                // 멀티탭이 꽉 찬 경우, 제거할 전기용품 찾기
                int maxIndex = -1;
                int deviceToUnplug = -1;

                for (int j = 0; j < multiTap.size(); j++) {
                    int device = multiTap.get(j);
                    int nextUse = 0;

                    for (int k = i + 1; k < K; k++) {
                        if (sequence[k] == device) {
                            nextUse = k;
                            break;
                        }
                    }

                    if (nextUse > maxIndex) {
                        maxIndex = nextUse;
                        deviceToUnplug = device;
                    }

                    // 전기용품이 앞으로 사용되지 않는다면 바로 제거
                    if (nextUse == 0) {
                        deviceToUnplug = device;
                        break;
                    }
                }

                multiTap.remove((Integer) deviceToUnplug);
                multiTap.add(sequence[i]);
                result++;
            }
        }

        System.out.println(result);
    }
}
