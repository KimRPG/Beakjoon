import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,1,-1};
    boolean[][] visited;
    int[][] graph;
    int max;
    int maxY;
    public int solution(String[] maps) {
        int answer = 0;
        maxY = maps[0].length();
        graph = new int[maps.length][maxY];
        visited = new boolean[maps.length][maxY];
        max = maps.length;
        int[] start= new int[3];
        int[] lever = new int[3];
        int[] end = new int[3];
        for(int i = 0; i < maps.length; i++){
            char[] ch = maps[i].toCharArray();
            for(int j = 0; j < maxY; j++){
                if(ch[j] == 'S'){
                    start = new int[]{i,j,0};
                }
                if(ch[j] == 'L'){
                    lever = new int[]{i,j,0};
                }
                if(ch[j] == 'E'){
                    end = new int[]{i,j,0};
                }
                if(ch[j] == 'X'){
                    graph[i][j] = -1;
                }
            }
        }
        
        int a = BFS(start, lever);
        if(a == -1) {
            return -1;
        }
        visited = new boolean[maps.length][maxY];
        int b = BFS(lever, end);
        if(b == -1) {
            return -1;
        }
        return a+b;
    }
    public int BFS(int[] start, int[] end){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            if(end[0] == node[0] && end[1] == node[1]){
                return node[2];
            }
            for(int i = 0; i < 4; i++){
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];
                int step = node[2] + 1;
                if(nx >= max || nx < 0 || ny >= maxY || ny < 0) continue;
                if(visited[nx][ny]) continue;
                if(graph[nx][ny] == -1) continue;
                
                queue.add(new int[]{nx,ny,step});
                visited[nx][ny] = true;
            }
        }
        
        return -1;
    }
}