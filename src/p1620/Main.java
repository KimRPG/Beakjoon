package p1620;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Map<Integer, String> pokedex = new HashMap();
        Map<String, Integer> pokedex2 = new HashMap();
        ArrayList ans = new ArrayList();
        for (int i = 0; i < n; i++) {
            String name = s.next();
            pokedex.put(i + 1, name);
            pokedex2.put(name, i + 1);
        }
        for (int i = 0; i < m; i++) {
            ans.add(s.next());
        }
        for (Object e : ans) {
            if (isInteger(e.toString())) {
                System.out.println(pokedex.get(Integer.parseInt(e.toString())));
            } else {
                System.out.println(pokedex2.get(e.toString()));
            }
        }

    }

    public static boolean isInteger(String strValue) {
        try {
            Integer.parseInt(strValue);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
