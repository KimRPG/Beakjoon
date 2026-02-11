import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) ->{
                return o1[1] - o2[1];
            }
        );
        
        for(int[] target : targets){
            pq.add(target);
        }
        
        while(!pq.isEmpty()){
            int[] pre = pq.poll();
            int preE = pre[1];
            answer++;
            while(!pq.isEmpty()){
                int[] next = pq.poll();
                if(preE <= next[0]){
                    pq.add(next);
                    break;
                } 
            }
        }
        return answer;
    }
}