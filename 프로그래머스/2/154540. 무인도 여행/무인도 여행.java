import java.util.*;
class Solution {
    int[] dx ={-1,1,0,0};
    int[] dy ={0,0,-1,1};
    int[][] arr;
    int n,m;
    boolean[][] isVisit;
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();
        arr = new int[n][m];
        isVisit = new boolean[n][m];
        for(int i = 0; i < n; i++){
            char[] chars = maps[i].toCharArray();
            for(int j = 0; j < m; j++){
                if( chars[j] == 'X'){
                    arr[i][j] = -1;
                }else{
                    arr[i][j] = chars[j]-'0';
                }
            }
        }
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < m; j++){
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != -1 && !isVisit[i][j]){
                    list.add(dfs(i,j));
                }
                
            }
        }
        if(list.isEmpty()){
            return new int[]{-1};
        }
        
        return list.stream()
            .sorted()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    public int dfs(int x, int y){
        isVisit[x][y] = true;
        int totalScore = arr[x][y];
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= n || nx < 0 || ny >= m || ny < 0) continue;
            if(isVisit[nx][ny] || arr[nx][ny] == -1) continue;
            
            totalScore+= dfs(nx,ny);
        }
        
        return totalScore;
    }
}