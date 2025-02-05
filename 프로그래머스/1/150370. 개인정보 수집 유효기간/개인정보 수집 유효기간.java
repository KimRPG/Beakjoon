import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<>();
        int intToday = calToDay(today);
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i <terms.length ; i++){
            String[] termsToMap = terms[i].split(" ");
            int exp = Integer.parseInt(termsToMap[1]) * 28;
            map.put(termsToMap[0], exp);
        }
        for(int i = 0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            int privacyDay = calToDay(privacy[0]);
            int exp = map.get(privacy[1]);
            if(intToday>=privacyDay+exp){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i =0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
    
    public int calToDay(String today){
        String[] cal = today.split("\\.");
        int year = Integer.parseInt(cal[0]);
        int month = Integer.parseInt(cal[1]);
        int day = Integer.parseInt(cal[2]);
        return (year*12*28) + (month*28) + day;
    }
}