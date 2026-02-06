class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String ab = a+""+b;
        answer = Math.max(Integer.parseInt(ab),a*b*2);
        return answer;
    }
}