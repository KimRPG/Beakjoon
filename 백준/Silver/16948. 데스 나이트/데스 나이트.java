import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] isVisit;
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};
    static int x2,y2,N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        isVisit = new boolean[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        int answer = move(x1,y1);
        System.out.println(answer);
    }

    public static int move(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x,y,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0] == x2 && cur[1] == y2) return cur[2];
            for(int i = 0; i < 6; i++){
                int nx = cur[0]+ dx[i];
                int ny = cur[1]+ dy[i];
                int turn = cur[2]+ 1;
                if(nx<0 || ny<0 || nx>=N || ny>=N ) continue;
                if(isVisit[nx][ny]) continue;
                queue.add(new int[]{nx,ny,turn});
                isVisit[nx][ny] = true;
            }
        }
        return -1;
    }
}