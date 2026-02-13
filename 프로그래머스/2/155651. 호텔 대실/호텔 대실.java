class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] room = new int[1500];
        for(String[] time : book_time){
            int start = timeToInt(time[0]);
            int end = timeToInt(time[1]);
            for(int i = start; i < end + 10; i++){
                room[i]++;
            }
        }
        for(int i = 0; i < 1500 ; i++){
            answer = Math.max(answer, room[i]);
        }
        return answer;
    }
    public int timeToInt(String st){
        String[] time = st.split(":");
        int hour = Integer.parseInt(time[0]) * 60;
        int min = Integer.parseInt(time[1]);
        return hour+min;
    }
}