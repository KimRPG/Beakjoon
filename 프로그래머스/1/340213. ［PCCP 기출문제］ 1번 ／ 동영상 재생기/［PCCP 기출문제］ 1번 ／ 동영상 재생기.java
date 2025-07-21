class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int int_video_len = stringToTime(video_len);
        int int_pos = stringToTime(pos);
        int int_op_start = stringToTime(op_start);
        int int_op_end = stringToTime(op_end);
        
        int N = commands.length;
        for(int i = 0; i < N; i++){        
            if(commands[i].equals("next")){
                int_pos = next(int_video_len,int_pos,int_op_start,int_op_end);
            }
            else{
                int_pos = prev(int_video_len,int_pos,int_op_start,int_op_end);
            }
        }
        
        return ans(int_pos);
    }
    
    public int next(int video_len, int pos, int op_start, int op_end){
        if(pos <= op_end && op_start <= pos) pos = op_end;
        pos+=10;
        if(video_len <= pos) return video_len;
        else if(pos <= op_end && op_start < pos) return op_end;
        else return pos;
    }
    
    
    public int prev(int video_len, int pos, int op_start, int op_end){
        if(pos <= op_end && op_start <= pos) pos = op_end;
        pos -= 10;
        if(pos <= 0) return 0;
        else if(pos <= op_end && op_start < pos) return op_end;
        return pos;
    }
    
    
    public int stringToTime(String time){
        String[] st = time.split(":");
        int min = Integer.parseInt(st[0]);
        int sec = Integer.parseInt(st[1]);
        return min*60 + sec;
    }
    
    public String ans(int time){
        int min = time / 60;
        int sec = time % 60;
        return String.format("%02d:%02d",min,sec);
    }
}