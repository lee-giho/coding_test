# 📋 스택 2
- Link<br>
https://www.acmicpc.net/problem/28278
- 풀이 날짜<br>
2025.10.15

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 명령의 수 (1 ≤ N ≤ 1,000,000)

- 둘째 줄부터 N개의 줄<br>
command: 명령 (1 ≤ command ≤ 5)<br>
  - command가 1일 때 공백으로 구분되어 있는 num: 스택에 넣을 정수 (1 ≤ num ≤ 100,000)

### 출력값
- N개의 줄에 걸쳐 명령의 결과 출력

## 📝 코드 설계하기
(k = 출력 길이)
1. 명령의 수 N을 입력받는다. O(1)
2. 스택으로 사용할 정수 배열을 만들고 top을 0으로 초기화한다. O(1)
3. N번의 명령을 수행하며 결과를 출력 버퍼에 저장한다. O(N)
4. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(k)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 명령의 수 입력
    int[] stack = new int[N]; // 스택으로 사용할 배열
    int top = 0; // 스택의 원소 개수

    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      char command = line.charAt(0); // 명령

      switch (command) {
        case '1': // push
          int num = Integer.parseInt(line.substring(2)); // 삽입할 정수
          stack[top++] = num;
          break;
        case '2': // pop
          if (top == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[--top]).append("\n");
          }
          break;
        case '3': // size
          sb.append(top).append("\n");
          break;
        case '4': // empty
          sb.append(top == 0 ? 1 : 0).append("\n");
          break;
        case '5': // top
          if (top == 0) {
            sb.append(-1).append("\n");
          } else {
            sb.append(stack[top - 1]).append("\n");
          }
          break;
      }
    }

    System.out.println(sb.toString());
  }
}
```