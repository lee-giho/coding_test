# 📋 큐
- Link<br>
https://www.acmicpc.net/problem/10845
- 풀이 날짜<br>
2025.09.08

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 명령의 수 (1 ≤ N ≤ 10,000)
- 둘째 줄부터 N개의 줄<br>
command: 명령 (1 ≤ x ≤ 100,000)

### 출력값
- N개의 줄
명령에 따른 값 출력

## 📝 코드 설계하기
1. 명령의 수 N 입력받는다 O(1)
2. 큐를 구현하기 위한 배열과 front, back 변수를 초기화한다. O(1)
3. N번 반복하며 명령을 입력받는다. O(N)
- push x: queue[++back] = x
- pop: 큐가 비어 있으면 -1, 아니면 queue[front++]
- size: 큐가 비어 있으면 0, 아니면 back - front + 1
- empty: 큐가 비어 있으면 1, 아니면 0
- front: 큐가 비어 있으면 -1, 아니면 queue[front]
- back: 큐가 비어 있으면 -1, 아니면 queue[back]
4. StringBuilder에 저장된 문자열 출력 O(N)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령의 개수 N 입력받기

    int[] queue = new int[N]; // 큐를 구현할 배열
    int front = 0; // 큐의 맨 앞 인덱스
    int back = -1; // 큐의 맨 뒤 인덱스

    // N개의 명령 처리
    for (int i = 0; i < N; i++) {
      String command = br.readLine(); // 한 줄의 명령 입력받기

      if (command.startsWith("push")) {
        // push x: x를 꺼내 큐의 맨 뒤에 삽입
        int x = Integer.parseInt(command.substring(5));
        queue[++back] = x;
      } else if (command.equals("pop")) {
        // pop: 큐가 비어 있으면 -1 아니면 front 값을 꺼내고 front +1
        if (back < front) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue[front++]).append("\n");
        }
      } else if (command.equals("size")) {
        // size: 현재 큐의 크기, back-front+1 또는 0
        sb.append((back < front) ? 0 : (back-front)+1).append("\n");
      } else if (command.equals("empty")) {
        // empty: 큐가 비어있으면 1, 아니면 0
        sb.append(back < front ? 1 : 0).append("\n");
      } else if (command.equals("front")) {
        // front: 큐의 맨 앞 값 출력, 비어있으면 -1 출력
        if (back < front) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue[front]).append("\n");
        }
      } else if (command.equals("back")) {
        // back: 큐의 맨 뒤 값 출력, 비어 있으면 -1 출력
        if (back < front) {
          sb.append(-1).append("\n");
        } else {
          sb.append(queue[back]).append("\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}
```