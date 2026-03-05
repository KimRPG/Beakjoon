import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        // 인덱스를 저장할 덱 (내림차순 유지용)
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < stones.length; i++) {
            // 1. 윈도우 범위를 벗어난 인덱스 제거 (i - k 위치)
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. 현재 값보다 작은 값들은 덱 뒤에서 모두 제거 (내림차순 유지)
            // 현재 stones[i]가 들어오면 기존의 작은 값들은 최댓값이 될 가능성이 사라짐
            while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) {
                deque.pollLast();
            }

            // 3. 현재 인덱스 추가
            deque.offerLast(i);

            // 4. 첫 번째 윈도우가 완성되는 시점(i >= k-1)부터 최댓값 수집
            if (i >= k - 1) {
                // 덱의 맨 앞(peekFirst)에는 현재 구간의 최댓값 인덱스가 있음
                // 이 최댓값들 중에서 '가장 작은 값'이 전체 건널 수 있는 인원수
                answer = Math.min(answer, stones[deque.peekFirst()]);
            }
        }

        return answer;
    }
}