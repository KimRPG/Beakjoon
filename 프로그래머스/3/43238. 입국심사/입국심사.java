import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = (long) n * times[times.length - 1];
        while(right > left){
            long mid = (left + right) / 2;
            long sum = 0;
            for(int time : times){
                sum += (mid / time); 
            }
            if (sum >= n) {
                answer = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}