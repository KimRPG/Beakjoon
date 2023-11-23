package bronze.p1076;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("black", 0);
        hashMap.put("brown", 1);
        hashMap.put("red", 2);
        hashMap.put("orange", 3);
        hashMap.put("yellow", 4);
        hashMap.put("green", 5);
        hashMap.put("blue", 6);
        hashMap.put("violet", 7);
        hashMap.put("grey", 8);
        hashMap.put("white", 9);

        Scanner s = new Scanner(System.in);
        String one = s.nextLine();
        String two = s.nextLine();
        String three = s.nextLine();

        long hi = (long) hashMap.get(one) * 10;  // Use long to avoid integer overflow
        int hi2 = hashMap.get(two);
        long ans = hi + hi2;
        ans *= Math.pow(10, hashMap.get(three));

        System.out.println(ans);
    }
}
