import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);
        int[] arr = new int[N];
        st = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st[i]);
        }
        int max = -1000000000;
        int slide = 0;
        for(int i =0; i< K; i++){
            slide += arr[i];
        }
        max = Math.max(max, slide);
        for (int i = 0; i < N - K; i++) {
            slide -= arr[i];
            slide += arr[K + i];
            max = Math.max(max,slide);
        }
        System.out.println(max);
    }


}