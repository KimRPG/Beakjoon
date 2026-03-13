class Solution {
    public String solution(String s) {
        String answer = "";
        String[] a = s.split(" ");
        int max = -1000000;
        int min = 1000000;
        for(String b : a){
            int num = Integer.parseInt(b);
            max = Math.max(num,max);
            min = Math.min(num,min);
        }
        answer += min + " " + max;
        return answer;
    }
}