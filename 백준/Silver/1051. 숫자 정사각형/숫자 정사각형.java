import javax.swing.plaf.TreeUI;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int size = Math.min(N, M);
        boolean isTrue = false;
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] numbers = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = numbers[j] - '0';
            }
        }

        while (size != 1) {
            for (int i = 0; i <= N - size; i++) {
                for (int j = 0; j <= M - size; j++) {
                    if (arr[i][j] == arr[i][j + size - 1]
                            && arr[i][j] == arr[i + size - 1][j]
                            && arr[i][j] == arr[i + size - 1][j + size - 1]
                    ) {
                        isTrue = true;
                        break;
                    }
                    if(isTrue) break;
                }
            }
            if(isTrue) break;
            else size--;
        }
        System.out.println(size * size);
    }


}

