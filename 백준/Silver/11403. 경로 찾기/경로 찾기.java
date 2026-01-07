import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] isVisit;
    static int[][] graph;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisit = new boolean[N][N];
        graph = new int[N][N];

        for(int i = 0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j< N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i< N ; i++){
            dfs(-1,i,i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N;i++){
            for(int j = 0; j< N;j++){
                sb.append(isVisit[i][j]? 1 : 0);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    public static void dfs(int cur, int next,int root){
        if(cur == -1){
            for(int i = 0; i< N; i++){
                if(graph[next][i] == 1) dfs(next, i,root);
            }
            return;
        }
        if(isVisit[root][next]) return;

        isVisit[root][next] =true;
        for(int i = 0; i< N; i++){
            if(graph[next][i] == 1) dfs(next, i,root);
        }
    }
}
