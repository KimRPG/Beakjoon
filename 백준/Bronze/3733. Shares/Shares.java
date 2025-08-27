import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextInt()) {
        	int n = sc.nextInt();
        	int s = sc.nextInt();
        	System.out.println(s / (n + 1));
        }       
    }
}