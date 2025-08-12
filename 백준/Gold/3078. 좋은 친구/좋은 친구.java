import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);
        int[] arr = new int[N];
        for(int i = 0; i< N; i++){
            arr[i] = br.readLine().length();
        }
        long ans = 0L;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < K + 1; i++) {
            if (map.containsKey(arr[i])) {
                ans += map.get(arr[i]);
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (int i = K + 1; i < N; i++) {
            int outgoingLength = arr[i - K - 1];
            map.put(outgoingLength, map.get(outgoingLength) - 1);
            int incomingLength = arr[i];
            ans += map.getOrDefault(incomingLength, 0);
            map.put(incomingLength, map.getOrDefault(incomingLength, 0) + 1);
        }
        System.out.println(ans);
    }

}

