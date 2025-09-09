import java.util.*;
class Solution {
    HashMap<String, Integer> map;
    String[] answer;
    public String[] solution(String[] players, String[] callings) {
        answer = players;
        map = new HashMap<>(); 
        for(int i = 0; i < players.length ; i++){
            map.put(players[i], i);
        }
        for(String st : callings){
            change(st);
        }
        return answer;
    }
    public void change(String player){
        int place = map.get(player);
        String player2 = answer[place - 1];
        answer[place - 1] = player;
        answer[place] = player2;
        
        map.put(player, place-1);
        map.put(player2, place);
    }
}