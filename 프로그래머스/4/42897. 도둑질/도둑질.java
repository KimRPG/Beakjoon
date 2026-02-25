class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[] dpo = new int[n];
        int[] dpx = new int[n];
        
        dpo[0] = dpo[1] = money[0];
        dpx[1] = money[1];
        
        for(int i = 2; i < n; i++){
            dpo[i] = Math.max(dpo[i-2]+money[i],dpo[i-1]);
            dpx[i] = Math.max(dpx[i-2]+money[i],dpx[i-1]);
        }
        return Math.max(dpx[n-1],dpo[n-2]);
    }
}