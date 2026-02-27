import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase(); // step 1
        char[] idChars = new_id.toCharArray();
        for(char idChar : idChars){
            if(idChar == '-' || idChar == '_' || idChar == '.'){
                answer += idChar;
            }else if(idChar <= '9' && idChar >= '0' ){
                answer += idChar;
            }else if(idChar <= 'z' && idChar >= 'a'){
                answer += idChar;
            }
        }
        StringBuffer sb =  new StringBuffer(answer);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i < sb.length();i++){
            if(sb.charAt(i-1) == '.' && sb.charAt(i) == '.'){
                list.add(i);
            }
        }
        int idx = 0;
        for(int del : list){
            sb.deleteCharAt(del-idx);
            idx++;
        }
        if(sb.charAt(0) == '.'){
            sb.deleteCharAt(0);
        }
        if(sb.length() >= 1 && sb.charAt(sb.length()-1) == '.'){
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(sb.length() == 0){
            sb.append("a");
        }
        
        if(sb.length() >= 16){
            sb = new StringBuffer(sb.substring(0,15));
        }
        if(sb.length() >= 1 && sb.charAt(sb.length()-1) == '.'){
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(sb.length() <= 2){
            for(int i = 0; i <= 3 - sb.length(); i++){
                sb.append(sb.charAt(sb.length()-1));
            }
        }
        
        return sb.toString();
    }
}