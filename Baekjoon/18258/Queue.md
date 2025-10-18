# 📋 큐 2
- Link<br>
https://www.acmicpc.net/problem/18258
- 풀이 날짜<br>
2025.10.18

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 명령의 수 (1 ≤ N ≤ 2,000,000)

- 둘째 줄부터 N개의 줄<br>
command: 수행할 명령
  - push일 때, 공백으로 구분된 command와 value (1 ≤ value ≤ 100,000)

### 출력값
- N개의 줄에 걸쳐 명령에 해당하는 값 출력

## 📝 코드 설계하기
1. 명령의 수 N 입력받기 O(1)
2. 명령을 수행할 큐 초기화하기 O(1)
3. N개의 명령을 입력받으며 수행한 결과를 출력 버퍼에 저장한다. O(N)
4. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령 개수 입력
    Deque<Integer> queue = new ArrayDeque<>(); // 큐

    // 명령을 입력받고 수행
    for (int i = 0; i < N; i++) {
      String command = br.readLine();

      if (command.startsWith("push")) {
        int value = Integer.parseInt(command.split(" ")[1]);
        queue.addLast(value);
      } else if (command.equals("pop")) {
        sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
      } else if (command.equals("size")) {
        sb.append(queue.size()).append("\n");
      } else if (command.equals("empty")) {
        sb.append(queue.isEmpty() ? 1 : 0).append("\n");
      } else if (command.equals("front")) {
        sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
      } else if (command.equals("back")) {
        sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
      }
    }

    System.out.println(sb);
  }
}
```