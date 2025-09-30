import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<String[]> list = new ArrayList<>();
        int len = record.length;
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0 ; i < len ; i++){
            String[] log = new String[2];
            String[] line = record[i].split(" ");
            String command = line[0];
            String uid = line[1];
            if(command.equals("Enter")){
                String nickname = line[2];
                log[0] = command;
                log[1] = uid;
                map.put(uid,nickname);
                list.add(log);
            }else if(command.equals("Leave"))
            {
                log[0] = command;
                log[1] = uid;
                list.add(log);
            }else{
                String nickname = line[2];
                map.put(uid,nickname);
            }
        }
        len = list.size();
        String[] answer = new String[len];
        for(int i = 0; i < len; i++){
            String[] log = list.get(i);
            String hi = log[0].equals("Enter")? "들어왔습니다." : "나갔습니다.";
            String st = map.get(log[1])+"님이 "+ hi;
            answer[i] = st;
        }
        return answer;
    }
}