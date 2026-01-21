import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : scoville){
            pq.add(a);
        }
        while(!pq.isEmpty()){
            int first = pq.poll();
            if(first >= K) {
                pq.add(first);
                break;
            }
            if(pq.isEmpty()) break;
            answer++;
            int second =pq.poll();
            pq.add(first + (second*2));
            
        }
        return pq.isEmpty()? -1 : answer;
    }
}