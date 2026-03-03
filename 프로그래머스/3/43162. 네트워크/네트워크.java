import java.util.*;
class Solution {
    int[][] graph;
    boolean[] isVisit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new int[n][n];
        Queue<Integer> queue = new ArrayDeque<>();
        isVisit = new boolean[n];
        for(int i = 0; i < n; i++){
            int[] computer = computers[i];
            for(int j = 0; j < n; j++){
                graph[i][j] = computer[j];
            }
        }
        
        for(int j = 0 ; j < n; j++){
            if(!isVisit[j]){
                answer++;
                queue.add(j);
                isVisit[j] = true;
                while(!queue.isEmpty()){
                    int curr = queue.poll();
                    for(int i = 0; i < n; i++){
                        if(isVisit[i]){
                            continue;
                        }
                    if(graph[curr][i] != 1) continue;
                
                    isVisit[i] = true;
                    queue.add(i);
                    }
                }
            }
        }

        
        return answer;
    }
}