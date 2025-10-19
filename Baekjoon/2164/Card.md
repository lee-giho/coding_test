# 📋 카드 2
- Link<br>
https://www.acmicpc.net/problem/2164
- 풀이 날짜<br>
2025.10.19

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 카드의 수 (1 ≤ N ≤ 500,000)

### 출력값
- 제일 마지막에 남게 되는 카드의 번호를 출력

## 📝 코드 설계하기
1. 카드의 수 N 입력받는다. O(1)
2. 반복문을 통해 N개의 카드를 큐에 저장한다. O(N)
3. 카드가 하나 남을 때까지 반복하며 아래 과정을 수행한다. O(N)
   - 맨 위에 있는 카드를 버린다.
   - 맨 위에 있는 카드를 제일 아래로 옮긴다.
4. 하나 남은 카드의 번호를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 카드의 수 입력

    // 카드를 입력받아 큐에 저장
    Deque<Integer> queue = new ArrayDeque<>(N);
    for (int i = 1; i < N + 1; i++) {
      queue.addLast(i);
    }

    // 카드가 하나 남을 때까지 반복
    while (queue.size() > 1) {
      queue.pollFirst(); // 멘 위 카드 버리기
      queue.addLast(queue.pollFirst()); // 맨 위 카드 제일 아래로 옮기기
    }

    System.out.println(queue.pollFirst());
  }
}
```