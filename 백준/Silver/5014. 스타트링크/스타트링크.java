import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        boolean[] isVisit = new boolean[F+1];
        int answer = -1;
        Queue<Elv> queue = new ArrayDeque<>();
        queue.add(new Elv(S, 0));
        isVisit[S] = true;
        while(!queue.isEmpty()){
            Elv current = queue.poll();
            int curFloor = current.floor;
            int curTurn = current.turn;
            isVisit[curFloor] = true;
            if(curFloor== G){
                answer = current.turn;
                break;
            }
            int nextUp = curFloor + U;
            if (nextUp <= F && !isVisit[nextUp]) {
                isVisit[nextUp] = true;
                queue.add(new Elv(nextUp, curTurn + 1));
            }

            int nextDown = curFloor - D;
            if (nextDown >= 1 && !isVisit[nextDown]) {
                isVisit[nextDown] = true;
                queue.add(new Elv(nextDown, curTurn + 1));
            }
        }

        System.out.println(answer == -1 ? "use the stairs" :answer);
    }

    public static class Elv{
        int floor;
        int turn;

        public Elv(int cur, int turn){
             this.floor = cur;
             this.turn = turn;
        }
    }
}