# 📋 풍선 터뜨리기
- Link<br>
https://www.acmicpc.net/problem/2346
- 풀이 날짜<br>
2025.10.21

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 풍선의 개수 (1 ≤ N ≤ 1,000)

- 둘째 줄<br>
value: 각 풍선 안의 종이에 적혀 있는 수 (value != 0)

### 출력값
- 터진 풍선의 번호를 공백으로 구분해 출력

## 📝 코드 설계하기
1. 풍선의 개수 N을 입력받는다. (1)
2. 풍선의 번호와 값을 덱에 입력한다. O(N)
3. 덱에 값이 없을 때까지 반복한다. O(N)
    - 맨 앞 풍선을 터뜨리고 번호를 출력 버퍼에 저장한다.
    - 풍선의 값에 따라 덱을 회전시킨다.
      - 양수: 오른쪽으로 next-1 회전
      - 음수: 왼쪽으로 -next 회전
4. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static class Balloon {
    int index; // 풍선의 번호
    int value; // 종이에 적힌 값

    Balloon(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 풍선의 개수 입력
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 덱에 풍선의 번호와 종이에 적힌 값 입력
    ArrayDeque<Balloon> deque = new ArrayDeque<>();
    for (int i = 1; i < N + 1; i++) {
      int value = Integer.parseInt(st.nextToken());
      deque.addLast(new Balloon(i, value));
    }

    // 덱에 값이 없을 때까지 반복
    while (!deque.isEmpty()) {
      // 맨 앞 풍선 터뜨리고 번호 출력
      Balloon currentBalloon = deque.pollFirst();
      sb.append(currentBalloon.index).append(" ");

      if (deque.isEmpty()) {
        break;
      }

      // 현재 풍선의 값에 따라 덱 회전
      int next = currentBalloon.value;
      if (next > 0) { // 양수, 오른쪽으로 next-1 회전
        for (int i = 0; i < next - 1; i++) {
          deque.addLast(deque.pollFirst());
        }
      } else { // 음수, 왼쪽으로 -next 회전
        for (int i = 0; i < -next; i++) {
          deque.addFirst(deque.pollLast());
        }
      }
    }

    System.out.println(sb.toString());
  }
}
```