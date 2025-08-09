import java.util.Scanner;

/**
 * 문제: Rev(Rev(X) + Rev(Y)) 계산하기
 *
 * 이 프로그램은 두 양의 정수 X와 Y를 입력받아,
 * 각 숫자를 뒤집고(Rev), 더한 후, 그 결과를 다시 뒤집어 출력합니다.
 */
public class Main {

    /**
     * 정수의 자릿수를 뒤집는 Rev 함수
     * @param n 뒤집을 양의 정수
     * @return 자릿수가 역순이 된 정수
     */
    public static int rev(int n) {
        // 1. 숫자를 문자열로 변환
        String str = Integer.toString(n);

        // 2. StringBuilder를 사용하여 문자열을 뒤집음
        StringBuilder sb = new StringBuilder(str);
        String reversedStr = sb.reverse().toString();

        // 3. 뒤집힌 문자열을 다시 정수로 변환하여 반환
        //    이때 "001"과 같은 형태는 자동으로 1로 변환됨
        return Integer.parseInt(reversedStr);
    }

    public static void main(String[] args) {
        // 입력을 받기 위한 Scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 두 양의 정수 X와 Y를 입력받음
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 문제의 요구사항에 따라 계산을 수행
        // 1. Rev(X)와 Rev(Y)를 각각 계산
        int revX = rev(x);
        int revY = rev(y);

        // 2. 두 결과를 더함
        int sumOfReversed = revX + revY;

        // 3. 합계를 다시 Rev 함수에 적용
        int finalResult = rev(sumOfReversed);

        // 최종 결과를 출력
        System.out.println(finalResult);

        // Scanner 리소스 정리
        sc.close();
    }
}