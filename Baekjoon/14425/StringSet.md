# 📋 문자열 집합
- Link<br>
https://www.acmicpc.net/problem/14425
- 풀이 날짜<br>
2025.10.01

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 M<br>
  - N: 집합에 포함된 문자열의 개수 (1 ≤ N ≤ 10,000)<br>
  - M: 검사할 문자열의 개수 (1 ≤ M ≤ 10,000)<br>

- 둘째 줄부터 N개의 줄<br>
집합 S에 포함되어 있는 문자열<br>

- N+2째 줄부터 M개의 줄<br>
검사해야 하는 문자열<br>

### 출력값
- M개의 문자열 중 총 몇 개가 집합 S에 포함되어 있는지 출력<br>

## 📝 코드 설계하기
1. 문자열의 개수 N과 검사할 문자열의 개수 M을 입력받는다. O(1)
2. N개의 문자열을 HashSet에 저장한다. O(N)
3. M개의 문자열을 contains로 개수를 카운트한다. O(M)
4. 포함된 문자열의 개수를 출력한다. O(1)

총 시간 복잡도 = O(N + M)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 집합에 포함된 문자열의 개수
    int M = Integer.parseInt(st.nextToken()); // 검사할 문자열의 개수

    HashSet<String> set = new HashSet<>(N*2); // 집합 S

    // 집합 S에 문자열 입력
    for (int i = 0; i < N; i++) {
      set.add(br.readLine());
    }

    // 집합 S에 포함되어 있는 문자열 개수 세기
    int count = 0;
    for (int i = 0; i < M; i++) {
      if (set.contains(br.readLine())) count++;
    }

    System.out.println(count);
  }
}
```