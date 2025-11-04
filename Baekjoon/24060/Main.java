import java.io.*;
import java.util.*;

public class Main {

  static int[] A; // 원본 배열
  static int[] temp; // 임시 배열
  static long K; // 저장 횟수
  static long count = 0; // A에 저장된 횟수
  static int answer = -1; // K번째에 저장된 값

  // 병합 정렬
  static void mergeSort(int p, int r) {
    if (p < r) {
      int q = (p + r) / 2; // 중간 인덱스
      mergeSort(p, q); // 왼쪽 절반 정렬
      mergeSort(q + 1, r); // 오른쪽 절반 정렬
      merge(p, q, r); // 병합
    }
  }

  // 두 구간을 병합해서 정렬된 상태로 만듦
  static void merge(int p, int q, int r) {
    int i = p; // 왼쪽 부분 배열 시작 인덱스
    int j = q + 1; // 오른쪽 부분 배열 시작 인덱스
    int t = 0; // temp 배열 인덱스

    // 두 배열을 비교하여 temp에 작은 값부터 저장한다.
    while (i <= q && j <= r) {
      if (A[i] <= A[j]) {
        temp[t++] = A[i++];
      } else {
        temp[t++] = A[j++];
      }
    }

    // 왼쪽 배열이 남은 경우
    while (i <= q) {
      temp[t++] = A[i++];
    }

    // 오른쪽 배열이 남은 경우
    while (j <= r) {
      temp[t++] = A[j++];
    }

    // temp 배열을 A 배열에 저장하기
    i = p;
    t = 0;
    while (i <= r) {
      A[i] = temp[t++];
      count++;

      // count와 K가 같아질 때 값을 answer에 기록
      if (count == K && answer == -1) {
        answer = A[i];
      }

      i++;
    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 배열 A의 크기
    K = Long.parseLong(st.nextToken()); // 저장 횟수

    A = new int[N];
    temp = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    // 병합 정렬
    mergeSort(0, N - 1);

    System.out.println(answer);
  }
}