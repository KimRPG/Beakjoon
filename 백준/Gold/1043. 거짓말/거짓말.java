import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        // 진실을 아는 사람들의 정보
        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        boolean[] knowsTruth = new boolean[N + 1];

        for (int i = 0; i < truthCount; i++) {
            knowsTruth[Integer.parseInt(st.nextToken())] = true;
        }

        // 각 파티의 참석자 정보를 저장
        ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            ArrayList<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(Integer.parseInt(st.nextToken()));
            }
            parties.add(party);
        }

        // 진실을 아는 사람들이 있는 파티를 찾아서 전파
        boolean changed;
        do {
            changed = false;
            for (ArrayList<Integer> party : parties) {
                boolean hasTruthTeller = false;
                // 파티에 진실을 아는 사람이 있는지 확인
                for (int person : party) {
                    if (knowsTruth[person]) {
                        hasTruthTeller = true;
                        break;
                    }
                }

                // 진실을 아는 사람이 있다면 모든 참석자가 진실을 알게 됨
                if (hasTruthTeller) {
                    for (int person : party) {
                        if (!knowsTruth[person]) {
                            knowsTruth[person] = true;
                            changed = true;
                        }
                    }
                }
            }
        } while (changed); // 더 이상 변화가 없을 때까지 반복

        // 거짓말을 할 수 있는 파티 수 계산
        int answer = 0;
        for (ArrayList<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (knowsTruth[person]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }
}