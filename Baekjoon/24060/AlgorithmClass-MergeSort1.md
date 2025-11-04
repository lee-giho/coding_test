# 📋 알고리즘 수업 - 병합 정렬 1
- Link<br>
https://www.acmicpc.net/problem/24060
- 풀이 날짜<br>
2025.11.04

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 K<br>
  - N: 배열 A의 크기 (5 ≤ N ≤ 500,000)<br>
  - K: 저장 횟수 (1 ≤ K ≤ 10<sup>8</sup>)

- 둘째 줄<br>
공백으로 구분된 배열 A의 원소 N개<br>
  - A<sub>i</sub>: 배열 A의 원소 (1 ≤ A<sub>i</sub> ≤ 10<sup>9</sup>)

### 출력값
- 배열 A에 K 번째 저장되는 수 출력
- 저장 횟수가 K보다 작으면 -1 출력

## 📝 코드 설계하기
1. 배열 A의 크기와 저장 횟수 K를 입력받는다. O(1)
2. 병합 정렬을 재귀로 호출한다. O(N log N)
    - 왼쪽 배열 부분 정렬
    - 오른쪽 배열 부분 정렬
    - 정렬된 두 배열 부분 병합
3. 병합 O(N log N)
    - 왼쪽 배열 부분과 오른쪽 배열 부분 중 작은 값을 temp에 차례로 저장
    - 한쪽이 다 사라지면 전부 temp에 저장
    - temp 배열의 값을 A 배열에 저장하며 K가 되는 순간의 A[i] 값을 answer에 저장한다.
4. 전체 정렬이 끝난 뒤 answer의 값을 출력한다. O(1)

총 시간 복잡도 = O(N log N)

## ✅ 정답 코드
```java
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
```