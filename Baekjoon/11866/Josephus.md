# 📋 요세푸스 문제 0
- Link<br>
https://www.acmicpc.net/problem/11866
- 풀이 날짜<br>
2025.08.31

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 K (1 ≤ K ≤ N ≤ 1,000)<br>
N: 사람의 수<br>
K: 제거할 순번

### 출력값
- 요세푸스 순열 출력

### 생각해 본 방법
N = 7, K = 3일 때

1, 2, 3, 4, 5, 6, 7<br>
2, 3, 4, 5, 6, 7, 1<br>
3, 4, 5, 6, 7, 1, 2

이렇게 맨 앞 요소를 K번 뒤로 보내며 K번째 요소를 꺼내 출력할 수 있게 한다.

## 📝 코드 설계하기
1. 사람의 수 N과 정수 K를 입력받는다. O(1)
2. 큐에 1...N을 순서대로 넣는다. O(N)
3. 큐에 값이 없을 때까지 반복한다.
K번 반복하며 큐의 첫 번째 요소를 마지막으로 보낸다. O(K)<br>
큐의 맨 앞 요소를 StringBuilder에 넣는다. O(1)
4. StringBuilder를 출력한다. O(1)

총 시간 복잡도 = O(NK)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 사람의 수 입력
    int K = Integer.parseInt(st.nextToken()); // 제거할 순번 입력

    // 큐 자료구조 초기화
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i < N+1; i++) {
      queue.add(i);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("<");

    // 큐가 빌 때까지 반복
    while(!queue.isEmpty()) {
      for (int i = 0; i < K-1; i++) { // K번째 사람을 꺼내 출력하기 위해 K-1까지 반복하며 맨 앞 요소를 맨 뒤로 보냄
        queue.add(queue.poll());
      }
      int num = queue.poll(); // K번째 사람 꺼내기
      sb.append(num);
      if (!queue.isEmpty()) {
        sb.append(", ");
      }
    }

    sb.append(">");
    System.out.println(sb);
  }
}
```