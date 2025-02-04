import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i<friends.length; i++){
            map.put(friends[i],i);
        }
        
        int[] arr = new int[friends.length];
        int[][] graph = new int[friends.length][friends.length];
        
        for(int i = 0; i<gifts.length;i++){
            String[] fr = gifts[i].split(" ");
            arr[map.get(fr[0])]++;
            arr[map.get(fr[1])]--;
            graph[map.get(fr[0])][map.get(fr[1])]++;
        }
        for(int i = 0 ; i < friends.length; i++){
            int a = 0;
            for(int j = 0 ; j < friends.length; j++){
                if(i==j) continue;
                if(graph[i][j]>graph[j][i]) a++;
                if(graph[i][j]==graph[j][i]){
                    if(arr[i]>arr[j]) a++;
                }
            }
            answer = Math.max(answer,a);
        }
        
        return answer;
    }
}