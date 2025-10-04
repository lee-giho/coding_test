# 📋 숫자 카드 2
- Link<br>
https://www.acmicpc.net/problem/10816
- 풀이 날짜<br>
2025.10.04

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 가지고 있는 숫자 카드의 개수 (1 ≤ N ≤ 500,000)<br>

- 둘째 줄<br>
공백으로 구분된 정수 N개<br>
  - num: 가지고 있는 숫자 카드의 번호 (-10,000,000 ≤ num ≤ 10,000,000)<br>

- 셋째 줄<br>
M: 가지고 있는지 숫자인지 확인할 질문의 수 (1 ≤ N ≤ 500,000)<br>

- 넷째 줄<br>
공백으로 구분된 정수 M개<br>
  - query: 가지고 있는지 숫자인지 확인할 번호 (-10,000,000 ≤ num ≤ 10,000,000)<br>

### 출력값
- 질문에서 주어진 수를 몇 개 가지고 있는지 공백으로 구분해 출력

## 📝 코드 설계하기
1. 상근이가 가진 카드의 개수 N을 입력받는다. O(1)
2. 숫자 카드의 수 N개를 입력받는다. O(1)
3. 숫자에 대해 숫자와 빈도수를 저장한다. O(N)
4. 질문의 개수 M을 입력 받는다. O(1)
5. 질문에 대한 숫자의 빈도수를 출력 버퍼에 저장한다. O(M)
6. 출력 버퍼에 저장된 문자열을 출력한다. O(1)

총 시간 복잡도 = O(N + M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 가지고 있는 숫자 카드의 개수 입력
    HashMap<Integer, Integer> countMap = new HashMap<>(); // 숫자 카드에 대해 나온 횟수 저장하는 Map

    // 숫자 카드 입력받고 나온 횟수 계산 후 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    int M = Integer.parseInt(br.readLine()); // 가지고 있는지 숫자인지 확인할 질문의 수 입력
    st = new StringTokenizer(br.readLine());

    // 질문의 숫자 개수를 확인하고 출력 버퍼에 저장
    for (int i = 0; i < M; i++) {
      int query = Integer.parseInt(st.nextToken());
      sb.append(countMap.getOrDefault(query, 0)).append(" ");
    }

    System.out.println(sb.toString().trim());
  }
}
```