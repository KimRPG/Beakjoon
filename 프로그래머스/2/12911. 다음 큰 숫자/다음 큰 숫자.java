class Solution {
    public int solution(int n) {
        int answer = n+1;
        int one = Integer.bitCount(n);
        while(true){
            if(one == Integer.bitCount(answer)){
                break;
            }
            answer++;
        }
        return answer;
    }
}