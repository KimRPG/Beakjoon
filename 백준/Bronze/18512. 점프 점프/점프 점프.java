import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int X = Integer.parseInt(st.nextToken()); // A의 멀리뛰기 거리 
		int Y = Integer.parseInt(st.nextToken()); // B의 멀리뛰기 거리 
		int P1 = Integer.parseInt(st.nextToken()); // A 출발점
		int P2 = Integer.parseInt(st.nextToken()); // B 출발점
 
		// X와 Y중 보폭이 작은 것 먼저 넣기. (X(작음)가 Y(큼)집 앞에서 만나는 경우도 있음)
		ArrayList<int[]> list = new ArrayList<int[]>();
		if (X <= Y) { 
			list.add(new int[] { X, P1 }); // X먼저 넣기
			list.add(new int[] { Y, P2 }); // Y넣기
		} else { 
			list.add(new int[] { Y, P2 }); // Y먼저 넣기
			list.add(new int[] { X, P1 }); // X넣기
		}
 
		int cnt = 1; // 일반항 Kn = H1 + n * X
		while (true) {
			int num = list.get(0)[1] + cnt * list.get(0)[0]; // 일반항 = P(출발점) + n(cnt) * X(보폭)
			if (num >= 10000 + list.get(0)[1]) { // 출발지점에서 10000미터 이상 진행한 경우, 만날 수 없다고 판단
				System.out.println(-1); // 만날 수 없으므로 -1 출력하고
				break; // 종료
			}
			// (작은 보폭이 이동한 위치 - 큰 보폭의 시작점) % 큰 보폭의 크기 == 0이면 만날 수 있는 위치임 
			num -= list.get(1)[1]; 
			if (num >= 0 && num % list.get(1)[0] == 0) { // 만났음
				System.out.println(num + list.get(1)[1]); // 만난 위치 출력(num에 위에서 -해준만큼 다시 더하기)
				break; // 만났으므로 종료
			} else // 못 만났으면
				cnt++; // cnt증가시켜서 한 보폭 더 가보기
		}
	}
}