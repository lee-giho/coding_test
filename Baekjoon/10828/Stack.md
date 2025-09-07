# 📋 스택
- Link<br>
https://www.acmicpc.net/problem/10828
- 풀이 날짜<br>
2025.09.07

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 명령의 수 (1 ≤ N ≤ 10,000)
- 둘째 줄부터 N개의 줄<br>
command: 명령 (1 ≤ number ≤ 100,000)

### 출력값
- N개의 줄
명령에 따른 값 출력

## 📝 코드 설계하기
1. 명령의 수 N 입력받는다 O(1)
2. 스택을 구현하기 위한 배열과 top 변수를 초기화한다. O(1)
3. N번 반복하며 명령을 입력받는다. O(N)
- push number: 스택에 number를 추가
- pop: 스택이 비어 있으면 -1, 아니면 stack[top--]
- size: top+1 출력
- empty: 스택이 비어 있으면 1, 아니면 0
- top: 스택이 비어 있으면 -1, 아니면 stack[top]
4. StringBuilder에 저장된 문자열 출력 O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령의 개수 N 입력받기

    int[] stack = new int[N]; // 스택을 구현할 배열
    int top = -1; // 스택의 맨 위 인덱스

    // N개의 명령 처리
    for (int i = 0; i < N; i++) {
      String command = br.readLine(); // 한 줄의 명령 입력받기

      if (command.startsWith("push")) {
        // push: number 값을 추출해 스택에 저장
        int number = Integer.parseInt(command.substring(5));
        stack[++top] = number; // top을 +1하고 값 저장
      } else if (command.equals("pop")) {
        // pop: 스택이 비어 있으면 -1, 아니면 top에 해당하는 값 출력
        if (top == -1) {
          sb.append(-1).append("\n");
        } else {
          sb.append(stack[top--]).append("\n"); // top에 대항다는 값 출력 및 top -1
        }
      } else if (command.equals("size")) {
        // size: 현재 스택 크기(top+1)
        sb.append(top+1).append("\n");
      } else if (command.equals("empty")) {
        // empty: 비어 있으면 1, 아니면 0
        sb.append(top == -1 ? 1 : 0).append("\n");
      } else if (command.equals("top")) {
        // top: 비어 있으면 -1, 아니면 stack[top]
        if (top == -1) {
          sb.append(-1).append("\n");
        } else {
          sb.append(stack[top]).append("\n");
        }
      }
    }

    System.out.println(sb.toString());
  }
}
```