import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arr = new ArrayList<>();
        int K = Integer.parseInt(br.readLine());
        int size = -1;
        for (int i = 0; i < K; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                arr.remove(size); //O(n)
                size--;
            }
            else{
                arr.add(a); //O(1)
                size++;
            }
        }
        int ans = 0;
        for (int element : arr) {
            ans += element; //O(n)
        }
        System.out.println(ans);
    }
}
