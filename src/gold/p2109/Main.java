package gold.p2109;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class Main {
//    static Integer parseInt(String string) {
//        return Integer.parseInt(string);
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = parseInt(br.readLine());
//        int[] list = new int[10001];
//        int ans = 0;
//
//        List<int[]> jobs = new ArrayList<>();
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int a = parseInt(st.nextToken());
//            int b = parseInt(st.nextToken());
//            jobs.add(new int[]{a, b});
//        }
//
//        // 작업을 금액 기준으로 내림차순 정렬
//        jobs.sort((o1, o2) -> o2[0] - o1[0]);
//
//        for (int[] job : jobs) {
//            int pay = job[0];
//            int day = job[1];
//
//            // 가능한 마지막 날부터 탐색하여 비어있는 날을 찾음
//            for (int j = day; j >= 1; j--) {
//                if (list[j] == 0) {
//                    list[j] = pay;
//                    break;
//                }
//            }
//        }
//
//        for (int i : list) {
//            ans += i;
//        }
//        System.out.println(ans);
//    }
//}

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int d;
    static int p;
    static int maxDay;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> list = new PriorityQueue<>((o1,o2)-> o2[1]-o1[1]);
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            p=Integer.parseInt(st.nextToken());
            d=Integer.parseInt(st.nextToken());
            int[] arr = new int[2];
            arr[0]=d;
            arr[1]=p;maxDay=Math.max(d,maxDay);


            list.offer(arr);
        }
        int[] hi = new int[10001];

        while(!list.isEmpty()) {
            int[] poll = list.poll();
        }
//        PriorityQueue<Integer> q = new PriorityQueue<>();
//        while(!list.isEmpty()){
//            int[] poll = list.poll();
//            q.add(poll[1]);
//            if(q.size()>poll[0]) q.poll();
//        }
//        int ans=0;
//        while(!q.isEmpty()) ans+=q.poll();
//        System.out.println(ans);
    }
}
