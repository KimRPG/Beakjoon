class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                sb.append(i);
            }
        }
        String leftSide = sb.toString();
        

        return leftSide + "0" + sb.reverse().toString();
    }
}