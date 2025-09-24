# 📋 좌표 압축
- Link<br>
https://www.acmicpc.net/problem/18870
- 풀이 날짜<br>
2025.09.25

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 좌표의 개수 (1 ≤ N ≤ 1,000,000)<br>

- 둘째 줄<br>
X<sub>1</sub>, ..., X<sub>N</sub>: 공백으로 구분된 N개의 좌표 (-10<sup>9</sup> ≤ X<sub>i</sub> ≤ -10<sup>9</sup>)<br>

### 출력값
- 압축한 좌표를 공백으로 구분해 출력<br>

## 📝 코드 설계하기
1. 좌표의 개수 N과 좌표 N개를 입력받는다. O(N)
2. 좌표 배열을 복사하고 오름차순 정렬한다. O(N log N)
3. 연속된 동일한 값을 제거하고 개수를 기록한다. O(N)
4. 좌표를 이분 탐색으로 랭크를 구해 문자열에 추가한다. O(N log N)
5. 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N log N)

## ✅ 정답 코드
```java
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
```