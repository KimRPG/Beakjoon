class Solution {
    public int solution(String name) {
        int answer = 0;
        char[] nameChars = name.toCharArray();
        int[] count = new int[name.length()];
        int n = name.length();
        for(int i = 0; i < name.length(); i++){
            char ch = nameChars[i];
            int a =  ch - 'A';
            int b = 'Z' + 1 - ch;
            count[i] = Math.min(a,b);
            answer += count[i];
        }
        int max = 0;
        int a = 0;
        if(count[0] == 0) a++;
        int move = n - 1;
        for (int i = 0; i < n; i++) {
          
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
    
            move = Math.min(move, i * 2 + (n - next));
            
            move = Math.min(move, (n - next) * 2 + i);
        }

        answer += move;
        
        
        return answer;
    }
}