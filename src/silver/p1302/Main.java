package silver.p1302;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Map<String,Integer> ans  =new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = s.nextLine();
            if(ans.containsKey(book)) {
                int put = ans.get(book) ;
                put++;
                ans.put(book, put);
            }else {
                ans.put(book, 1);
            }
        }
        List<Integer> valueList = new ArrayList<>(ans.values());
        valueList.sort(Integer::compareTo);
        List<String> answerList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : ans.entrySet()) {
                if (entry.getValue().equals(valueList.get(valueList.size()-1))) {
                    answerList.add(entry.getKey());
                }
        }
            answerList.sort(null);
            System.out.println(answerList.get(0));



    }
}
