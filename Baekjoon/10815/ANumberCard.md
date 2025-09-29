# 📋 숫자 카드
- Link<br>
https://www.acmicpc.net/problem/10815
- 풀이 날짜<br>
2025.09.30

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 가지고 있는 숫자 카드의 개수 (1 ≤ N ≤ 500,000)<br>

- 둘째 줄<br>
card: 공백으로 구분된 N개의 정수 (-10,000,000 ≤ card ≤ 10,000,000)<br>

- 셋째 줄<br>
M: 확인할 숫자 카드의 개수 (1 ≤ N ≤ 500,000)<br>

- 넷째 줄<br>
x: 공백으로 구분된 M개의 정수 (-10,000,000 ≤ card ≤ 10,000,000)<br>

### 출력값
- 상근이가 가지고 있는 숫자이면 1, 아니면 0을 공백으로 구분해 출력<br>

## 📝 코드 설계하기
1. N과 N개의 정수를 입력받아 배열 cards에 저장한다. O(N)
2. cards 배열을 오름차순으로 정렬한다. O(N log N)
3. M과 M개의 숫자를 입력받는다. O(M)
4. M개의 숫자에 대해 Arrays.binarySearch로 존재 여부를 확인해 1또는 0을 출력 버퍼에 저장한다. O(M log N)
5. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O((N+M) log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드의 개수 N 입력

    // N개의 숫자를 배열에 저장
    int[] cards = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(cards); // 배열 오름차순 정렬

    int M = Integer.parseInt(br.readLine()); // 확인할 숫자 개수 M 입력

    // M개의 숫자를 이분 탐색을 통해 1/0으로 기록
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int x = Integer.parseInt(st.nextToken());
      sb.append(Arrays.binarySearch(cards, x) >= 0 ? 1 : 0).append(" "); // 찾으면 인덱스 반환 / 즉, >= 0이 참
    }

    System.out.println(sb.toString());
  }
}
```