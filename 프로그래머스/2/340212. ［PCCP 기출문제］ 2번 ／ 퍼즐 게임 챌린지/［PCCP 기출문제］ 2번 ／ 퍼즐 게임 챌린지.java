class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000;
        int answer = 0;

        while (start <= end) {
            int level = (start + end)/2;
            long totalTime = calc(diffs, times, level);

            if (totalTime <= limit) {
                answer = level;
                end = level - 1;
            } else {
                start = level + 1;
            }
        }
        return answer;
    }
    
    public long calc(int[] diffs, int[] times, int level){
        int length = diffs.length;
        long time = 0L;
        for(int i = 0; i<length; i++){
            int solveTimes = diffs[i] - level;
            if(level >= diffs[i]) time += times[i];
            else {
                if(i == 0) time = time + (times[i]*solveTimes) + times[i];
                else time = time + ((times[i] + times[i-1])*solveTimes) + times[i];
            }
        }
        return time;
    }
}