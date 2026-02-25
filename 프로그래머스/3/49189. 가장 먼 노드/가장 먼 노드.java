import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }
        int[] isVisit = new int[n+1];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int[] relate : edge){
            int x = relate[0];
            int y = relate[1];
            arr[x].add(y);
            arr[y].add(x);
        }
        queue.add(new int[]{1,1});
        isVisit[1] = 1;
        int max = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            ArrayList<Integer> node = arr[cur[0]];
            int weight = cur[1];
            for(int next : node){
                if(isVisit[next] == 0){
                    queue.add(new int[]{next,weight+1});
                    isVisit[next] = weight+1;
                    max = Math.max(weight+1,max);
                }
            }
        }
        
        for(int i : isVisit){
            if(i == max) answer++;
        }
        return answer;
    }
}