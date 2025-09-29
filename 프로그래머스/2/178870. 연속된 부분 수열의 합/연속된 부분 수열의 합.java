class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int len = sequence.length;
        int sum = sequence[0];
        int min = 1_000_000;
        while(start<=end && end < len){
            if(sum < k){
                if (end == len - 1) break;
                sum += sequence[++end];
            }
            else if(sum == k){
                if((end - start) < min){
                    min = end-start;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start++];
            }else{
                sum -= sequence[start++];
            }
        }
        return answer;
    }
}