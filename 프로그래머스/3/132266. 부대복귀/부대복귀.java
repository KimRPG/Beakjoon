import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n];
        
        for(int i = 0; i < n ; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            int start = road[0] - 1;
            int end = road[1] - 1;
            graph[start].add(end);
            graph[end].add(start);
        }
        
        // 🔥 destination에서 한 번만 BFS
        int[] dist = bfs(destination - 1, n);
        
        for(int i = 0; i < sources.length; i++){
            answer[i] = dist[sources[i] - 1];
        }
        
        return answer;
    }
    
    public int[] bfs(int start, int n){
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dist[start] = 0;
        
        while(!queue.isEmpty()){
            int current = queue.poll();
            
            for(int next : graph[current]){
                if(dist[next] == -1){
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }
        
        return dist;
    }
}