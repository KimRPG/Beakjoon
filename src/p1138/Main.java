package p1138;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] people = new int[n];
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            peopleIn(people, left, i, 0); // 0 2110 0 0
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(left[i]);
//        }

    }
    public static void peopleIn(int[] people, int[] left, int n, int a) {
        if(people[left[n]+a]==0){
            people[left[n]+a] = n + 1;
            System.out.println(left[n+a]+""+people[left[n+a]]);
        }else {
            System.out.println("emffla"+ " n: "+n + " a : "+ (a+1));
            peopleIn(people, left , n , (a+1));
        }
    }



}


//import java.io.BufferedReader;
//        import java.io.InputStreamReader;
//        import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int arr[] = new int[N];
//        boolean visit[] = new boolean[N];
//        st = new StringTokenizer(br.readLine());
//        for(int i = 0 ; i < N ; i++) {
//            int n = Integer.parseInt(st.nextToken());
//            int cnt = 0;
//            for(int j = 0 ; j < N ; j++) {
//                if(!visit[j]) {
//                    if(cnt == n) {
//                        visit[j] = true;
//                        arr[j] = i+1;
//                        break;
//                    }
//                    cnt++;
//                }
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0 ; i < N ; i++)
//            sb.append(arr[i]+" ");
//        System.out.println(sb);
//    }
//
//}