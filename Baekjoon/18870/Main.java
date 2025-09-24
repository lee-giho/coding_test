import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 좌표 개수 N 입력
    int[] arr = new int[N];

    // N개의 좌표 입력받고 배열에 저장
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // 좌표 배열 복사하고 오름차순 정렬
    int[] sorted = arr.clone();
    Arrays.sort(sorted);

    // 정렬된 배열에서 중복 제거
    int m = 0; // 압축된 좌표 개수
    if (N > 0) {
      m = 1;
      for (int i = 1; i < N; i++) {
        if (sorted[i] != sorted[m-1]) {
          sorted[m++] = sorted[i];
        }
      }
    }

    // 이분 탐색으로 압축 좌표 찾기
    for (int i = 0; i < N; i++) {
      int rank = Arrays.binarySearch(sorted, 0, m, arr[i]);
      sb.append(rank).append(" ");
    }

    System.out.println(sb.toString());
  }
}