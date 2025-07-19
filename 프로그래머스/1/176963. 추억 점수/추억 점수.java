import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> list = new ArrayList<>();
        int len = name.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++){
            map.put(name[i],yearning[i]);
        }
        for(String[] ph : photo){
            int total = 0;
            for(String p: ph){
                total += map.getOrDefault(p,0);
            }
            list.add(total);
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        
        
        return answer;
    }
}