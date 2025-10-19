# 📋 덱 2
- Link<br>
https://www.acmicpc.net/problem/28279
- 풀이 날짜<br>
2025.10.20

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 명령의 수 (1 ≤ N ≤ 1,000,000)

- 둘째 줄부터 N개의 줄<br>
line: 수행할 명령
  - line의 command가 1 또는 2<br>
    command X (1 ≤ X ≤ 100,000)
  - 그 외의 값<br>
    command

### 출력값
- N개의 줄에 걸쳐 명령에 해당하는 결과 출력

## 📝 코드 설계하기
1. 명령의 수 N을 입력받는다. O(1)
2. 덱으로 사용할 ArrayDeque를 생성한다. O(1)
3. N번 반복하며 아래의 명령을 처리하며 결과를 출력 버퍼에 저장한다. O(N)
    - 1 X -> 덱의 앞에 X 넣기
    - 2 X -> 덱의 뒤에 X 넣기
    - 3 -> 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력, 없으면 -1 출력
    - 4 -> 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력, 없으면 -1 출력
    - 5 -> 덱에 들어있는 정수의 개수 출력
    - 6 -> 덱이 비어있으면 1, 아니면 0 출력
    - 7 -> 덱에 정수가 있다면 맨 앞의 정수 출력, 없으면 -1 출력
    - 8 -> 덱에 정수가 있다면 맨 뒤의 정수 출력, 없으면 -1 출력
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

    int N = Integer.parseInt(br.readLine()); // 명령의 개수
    ArrayDeque<Integer> deque = new ArrayDeque<>(); // 덱 자료구조

    for (int i = 0; i < N; i++) {
      String line = br.readLine();

      char command = line.charAt(0); // 명령

      switch (command) {
        case '1': { // 덱의 앞에 정수 넣기
          int X = Integer.parseInt(line.substring(2)); // 입력할 정수
          deque.addFirst(X);
          break;
        }
        case '2': { // 덱의 뒤에 정수 넣기
          int X = Integer.parseInt(line.substring(2)); // 입력할 정수
          deque.addLast(X);
          break;
        }
        case '3': { // 덱에 정수가 있다면 맨 앞의 정수를 빼고 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
          break;
        }
        case '4': { // 덱에 정수가 있다면 맨 뒤의 정수를 빼고 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
          break;
        }
        case '5': { // 덱에 들어있는 정수의 개수 출력
          sb.append(deque.size()).append("\n");
          break;
        }
        case '6': { // 덱이 비어있으면 1, 아니면 0
          sb.append(deque.isEmpty() ? 1 : 0).append("\n");
          break;
        }
        case '7': { // 덱에 정수가 있다면 맨 앞의 정수 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
          break;
        }
        case '8': { // 덱에 정수가 있다면 맨 뒤의 정수 출력, 없으면 -1
          sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
          break;
        }
      }
    }

    System.out.println(sb.toString());
  }
}
```