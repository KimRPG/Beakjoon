import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void mergeSort(int[] arr, int left, int right) {
        // 배열 크기가 1 이하일 때 종료
        if (left < right) {
            int mid = left + (right - left) / 2; // 중간 인덱스 계산

            // 왼쪽 부분 배열 정렬
            mergeSort(arr, left, mid);

            // 오른쪽 부분 배열 정렬
            mergeSort(arr, mid + 1, right);

            // 병합
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        // 왼쪽과 오른쪽 부분 배열의 크기 계산
        int n1 = mid - left + 1; // 왼쪽 부분 배열 크기
        int n2 = right - mid;    // 오른쪽 부분 배열 크기

        // 임시 배열 생성
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // 원본 배열에서 데이터를 왼쪽과 오른쪽 배열로 복사
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        // 병합 작업
        int i = 0, j = 0, k = left; // i, j는 각각 leftArray와 rightArray의 포인터
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 왼쪽 배열에 남은 값을 복사
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // 오른쪽 배열에 남은 값을 복사
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 입력받기: 배열의 크기와 요소들
        int N = Integer.parseInt(br.readLine()); // 배열 크기
        int[] arr = new int[N]; // 배열 생성
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 각 요소 입력받기
        }

        // Merge Sort 호출
        mergeSort(arr, 0, N - 1);

        // 정렬된 배열 출력
        for (int num : arr) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
