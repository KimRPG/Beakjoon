import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        List<String> list = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        (o1,o2)->{
            return o1[1] - o2[1];
        });
        Stack<int[]> stack = new Stack<>();
        int len = plans.length;
        String[] answer = new String[len];
        
        for(int i = 0; i< len; i++){
            String[] plan = plans[i];
            String name = plan[0];
            int time = stringToTime(plan[1]);
            int playtime = Integer.parseInt(plan[2]);
            pq.add(new int[]{i,time,playtime});
        }
        
        while(!pq.isEmpty()){
            int[] a = pq.poll();
            
            if(!pq.isEmpty()){
                int[] b = pq.poll();
                if(a[1] + a[2] > b[1]){
                    int nTime = a[1]+a[2]-b[1];
                    stack.push(new int[]{a[0],a[1],nTime});
                }else{
                    list.add(plans[a[0]][0]);
                    int left = b[1] - (a[1] + a[2]);
                    while(left>0  && !stack.isEmpty()){
                        int[] c = stack.pop();
                        if(c[2] > left){
                            stack.push(new int[]{c[0],c[1],c[2]-left});
                            left = 0;
                        }else{
                            list.add(plans[c[0]][0]);
                            left -= c[2];
                        }
                    }
                }
                pq.add(b);
            }
            else{
                list.add(plans[a[0]][0]);
            } 
        }
        while(!stack.isEmpty()){
            list.add(plans[stack.pop()[0]][0]);
        }
        for(int i = 0 ; i < len ; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    
    public int stringToTime(String time){
        String[] t = time.split(":");
        int hour = Integer.parseInt(t[0]) * 60;
        int minute = Integer.parseInt(t[1]);
        return hour+minute;
    }
}