package p1094;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int count = 0;
        while (x!=0){
            if(x%2 ==1) count ++;
            x/=2;
        }
        System.out.println(count);
    }
}
