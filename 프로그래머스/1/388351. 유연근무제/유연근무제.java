class Solution {
    int NoDay1;
    int NoDay2;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        NoDay(startday);
        int len = schedules.length;
        for(int i =0; i< len; i++){
            int time = schedules[i];
            int ans = 0;
            for(int j = 0; j <7 ; j++){
                if(j == NoDay1) continue;
                if(j == NoDay2) continue;
                if(isSafe(time, timelogs[i][j])) ans++;
            }
            if(ans == 5) answer++;
        }
        return answer;
    }
    public void NoDay(int startday){
        if(startday == 1){NoDay1 = 5; NoDay2 = 6;}
        if(startday == 2){NoDay1 = 4; NoDay2 = 5;}
        if(startday == 3){NoDay1 = 3; NoDay2 = 4;}
        if(startday == 4){NoDay1 = 2; NoDay2 = 3;}
        if(startday == 5){NoDay1 = 1; NoDay2 = 2;}
        if(startday == 6){NoDay1 = 0; NoDay2 = 1;}
        if(startday == 7){NoDay1 = 6; NoDay2 = 0;}
    }
    public boolean isSafe(int time, int safe){
        int hour = time / 100;
        int min = time % 100;
        int safeHour = safe / 100;
        int safeMin = safe % 100;
        if(min + 10 >= 60) {
            hour++;
            min -= 50;
        }else{
            min += 10;
        }
        
        if(safeHour > hour){
            return false;
        }else{
            if(safeHour == hour){
                if(safeMin > min){
                    return false;
                }else{
                    return true;
                }
            }else{
                return true;
            }
        }
    }
}