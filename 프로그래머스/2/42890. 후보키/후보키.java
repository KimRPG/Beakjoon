import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        int maxMask = 1 << col;
        for (int mask = 1; mask < maxMask; mask++) {
            // 1) 최소성 검사: 이미 존재하는 후보키가 부분집합이면 건너뛰기
            boolean skip = false;
            for (int cand : candidateKeys) {
                if ((cand & mask) == cand) { // cand는 mask의 부분집합
                    skip = true;
                    break;
                }
            }
            if (skip) continue;

            // 2) 유일성 검사: 각 행을 mask에 해당하는 열들로 투영해서 Set에 넣어본다
            Set<String> seen = new HashSet<>();
            for (int r = 0; r < row; r++) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < col; c++) {
                    if ((mask & (1 << c)) != 0) {
                        // 컬럼 구분자를 포함해 합쳐서 충돌 방지
                        sb.append(relation[r][c]).append("|");
                    }
                }
                seen.add(sb.toString());
            }

            // 모든 행이 유일하면 후보키
            if (seen.size() == row) {
                candidateKeys.add(mask);
            }
        }

        return candidateKeys.size();
    }
}
