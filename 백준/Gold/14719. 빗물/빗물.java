import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] world = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int a = Integer.parseInt(st.nextToken());
            world[i] = a;
        }
        int water = 0;
        for (int i = 0; i < H; i++) {
            boolean flag = false;
            int waterCan = 0;
            for (int j = 0; j < W; j++) {
                if (!flag && world[j] > i) {
                    flag = true;
                } else if (flag && world[j] <= i) {
                    waterCan++;
                } else if (flag && world[j] > i && waterCan != 0) {
                    water += waterCan;
                    waterCan = 0;}
            }
        }
        System.out.println(water);
    }
}