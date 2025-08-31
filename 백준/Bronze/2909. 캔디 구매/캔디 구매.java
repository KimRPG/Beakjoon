import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int C = scan.nextInt();	// 사탕 가격
		int K = scan.nextInt();	// 0의 개수
		
		double num = Math.pow(10, K);	// 10의 K제곱
		
		int ans = (int) ((int)Math.round(C/num)*num);
		
		System.out.println(ans);
		
		scan.close();
	}

}