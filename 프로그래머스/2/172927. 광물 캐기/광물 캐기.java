import java.util.*;

class Solution {
    public static void cost(int[] costs, int a, int b, int c){ // 피로도 계산
        costs[0] += a;
        costs[1] += b;
        costs[2] += c;
    }
    
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int sum = picks[0] + picks[1] + picks[2]; // 곡괭이 갯수
        int[][] p = new int[sum][3]; 
        
        for (int i = 0 ; i < minerals.length; i += 5){
            int n = i/5;
            if(n == sum){
                break;
            }
            int[] costs = new int[3];
            for (int j = i ; j < i+5; j++){
                if (j == minerals.length){ // 마지막에 5개가 안되는 경우
                    break;
                }
                String x = minerals[j];
                if (x.equals("diamond")){
                    cost(costs,1,5,25);
                }
                else if (x.equals("iron")){
                    cost(costs,1,1,5);
                }
                else {
                    cost(costs,1,1,1);
                }
            }
            for (int l = 0 ; l < 3; l++){
                p[n][l] = costs[l];
            }
            costs = new int[3];
        }
        
        Arrays.sort(p, (a1, a2) -> (a2[2]-a1[2]));
        
        for(int i = 0; i < sum; i++){
            if(picks[0] > 0){
                answer += p[i][0];
                picks[0]--;
            }
            else if(picks[1] > 0){
                answer += p[i][1];
                picks[1]--;
            }
            else if(picks[2] > 0){
                answer += p[i][2];
                picks[2]--;
            }
        }
        
        return answer;
    }
}