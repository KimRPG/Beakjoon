class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] play = new int[n+1][n+1];
        for(int[] result : results){
            int win = result[0];
            int lose = result[1];
            play[win][lose] = 1;
            play[lose][win] = -1;
        }
        for(int i =1; i<n+1; i++){
            for(int j = 1; j < n+1;j++){
                for(int k = 1; k < n+1; k++){
                    if(play[i][k] == 1 && play[k][j] == 1){
                        play[i][j] = 1;
                        play[j][i] = -1;
                    } 
                    if(play[i][k] == -1 && play[k][j] == -1){
                        play[i][j] = -1;
                        play[j][i] = 1;
                    } 
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int a = 0;
            for(int j = 1; j <= n; j++){
                if(play[i][j] != 0) a++;
            }
            if(a == n-1) answer++;
        }
        
        return answer;
    }
}