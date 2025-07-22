import java.util.*;
class Solution {
    int N, M;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    boolean[][] visit;
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        visit = new boolean[N][M];
        visit[0][0] = true;
        answer = BFS(maps);
        return answer;
    }
    public int BFS(int[][] maps){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(now[0] == N-1 && now[1] == M-1) {
                return now[2];
            }
            for(int i=0; i < 4;i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                int n = now[2];
                if(nx<0 || nx >= N || ny<0 || ny>=M) continue;
                if(visit[nx][ny]) continue;
                if(maps[nx][ny] == 0 ) continue;
                queue.add(new int[]{nx,ny,n+1});
                visit[nx][ny] = true;
            }
        }
        return -1;
    }
}