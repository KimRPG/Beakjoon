import java.util.*;
class Solution {
    boolean[] isVisit;
    HashSet<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        isVisit = new boolean[user_id.length];    
        dfs(user_id,banned_id,0,0);
        return set.size();
    }
    
    public void dfs(String[] user_id, String[] banned_id,int depth, int idx){
        if(depth == banned_id.length){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < user_id.length; i++){
                sb.append(isVisit[i]);
            }
            set.add(sb.toString());
            return;
        } 
        for(int i = 0; i < user_id.length; i++){
            if(!isVisit[i] && isSame(user_id[i],banned_id[depth])){
                isVisit[i] = true;
                dfs(user_id, banned_id, depth+1, i);
                isVisit[i] = false;
            }
        }
    }
    
    public boolean isSame(String user, String ban){
        if(user.length() != ban.length()) return false;
        for(int i = 0; i < user.length(); i++){
            if(ban.charAt(i) == '*') continue;
            if(ban.charAt(i) != user.charAt(i)) return false;
        }
        
        return true;
    }
}