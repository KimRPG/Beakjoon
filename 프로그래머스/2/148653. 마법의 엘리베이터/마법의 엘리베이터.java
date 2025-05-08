class Solution {
    public int solution(int storey) {
        int answer = 0;

        while (storey != 0) {
            int a = storey % 10;
            int next = (storey / 10) % 10;

            if (a < 5) {
                answer += a;
                storey /= 10;
            } else if (a > 5) {
                answer += (10 - a);
                storey = storey / 10 + 1;
            } else { 
                if (next >= 5) {
                    answer += 5;
                    storey = storey / 10 + 1;
                } else {
                    answer += 5;
                    storey /= 10;
                }
            }
        }

        return answer;
    }
}
