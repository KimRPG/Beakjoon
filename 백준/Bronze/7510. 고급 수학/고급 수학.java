import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 테스트 케이스의 개수를 입력받습니다.
        int n = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스를 순회합니다.
        for (int i = 1; i <= n; i++) {
            // 세 변의 길이를 한 줄로 입력받습니다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 세 변의 길이를 저장할 배열을 생성합니다.
            int[] sides = new int[3];
            sides[0] = Integer.parseInt(st.nextToken());
            sides[1] = Integer.parseInt(st.nextToken());
            sides[2] = Integer.parseInt(st.nextToken());
            
            // 변의 길이를 오름차순으로 정렬합니다.
            Arrays.sort(sides);
            
            int a = sides[0];
            int b = sides[1];
            int c = sides[2]; // 가장 긴 변
            
            // 시나리오 번호를 출력합니다.
            System.out.println("Scenario #" + i + ":");
            
            // 피타고라스 정리를 확인합니다.
            // 변의 길이가 1000까지 가능하므로 제곱하면 int 범위를 넘을 수 있어 long으로 형변환하여 계산하는 것이 안전합니다.
            if ((long)a * a + (long)b * b == (long)c * c) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            
            // 각 시나리오 사이에 빈 줄을 출력합니다.
            System.out.println();
        }
        
        br.close();
    }
}