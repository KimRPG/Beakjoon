class Solution {
    char[][] graph;
    int x, y;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    //int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        x = park.length;
        y = park[0].length();
        int[] cur = new int[2];
        graph = new char[x][y];
        for(int i = 0; i < x; i++){
            char[] chars = park[i].toCharArray();
            for(int j = 0; j < y; j++){
                graph[i][j] = chars[j];
                if(chars[j] == 'S'){
                    cur[0] = i;
                    cur[1] = j;
                }
            }
        }
        int dir = 0;
        for(String command : routes){
            String[] com = command.split(" ");
            
            if(com[0].equals("N")) dir = 0;
            else if(com[0].equals("S")) dir = 1;
            else if(com[0].equals("W")) dir = 2;
            else if(com[0].equals("E")) dir = 3;
            int distance = Integer.parseInt(com[1]);
            if(cur[0] + dx[dir] * distance < 0 || cur[0] + dx[dir] * distance >= x || cur[1] + dy[dir]*distance < 0 || cur[1] + dy[dir] * distance >= y) continue;
            
            if(isCan(cur,dir, distance)){
                cur[0] += dx[dir] * distance;
                cur[1] += dy[dir] * distance;
            }
        }
        
        
        return cur;
    }
    
    public boolean isCan(int[] cur, int dir, int dist){
        for(int i = 1; i <= dist; i++){
            if(graph[cur[0] + dx[dir] * i][cur[1] + dy[dir]*i] == 'X'){
                return false;
            }
        }
        return true;
    }
}