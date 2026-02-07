
import java.util.*;

class Solution {
    
    private Map<Integer, Integer> map = new HashMap<>();
    private Map<Integer, Integer> map2 = new HashMap<>();
    private int First, Second;
    private int Answer;
    
    public int solution(int[] topping) {
        for (int i = 0; i < topping.length; i++) {
            int Now = topping[i];
            if (!map.containsKey(Now)) {
                map.put(Now, 1);
                First++;
            } else {
                map.put(Now, map.get(Now) + 1);
            }
        }
        
        for (int i = 0; i < topping.length; i++) {
            int Now = topping[i];
            map.put(Now, map.get(Now) - 1);
            if (map.get(Now) == 0) {
                First--;
            }
            
            if (!map2.containsKey(Now)) {
                map2.put(Now, 0);
                Second++;
            } else {
                map2.put(Now, map2.get(Now) + 1);
            }
            
            if (First == Second) {
                Answer++;
            }
        }
        
        return Answer;
    }
}