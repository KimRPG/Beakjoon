import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeMap<String, Integer> map = new TreeMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for (int i = 0; i < a; i++) {
            String[] strings = br.readLine().split("\\.");
            if (map.containsKey(strings[1])) {
                map.put(strings[1], map.get(strings[1]) + 1);
            }else{
                map.put(strings[1], 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String i : map.keySet()){ 
            System.out.println(i + " " + map.get(i));}
    }

}
