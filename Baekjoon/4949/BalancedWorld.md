# 📋 균형잡힌 세상
- Link<br>
https://www.acmicpc.net/problem/4949
- 풀이 날짜<br>
2025.10.16

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄부터 온점 하나(".")가 나올 때까지<br>
line: 균형잡혀 있는지 확인할 문자열 (1 ≤ line.length ≤ 100)<br>
마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호, 대괄호로 이루어져 있고 온점으로 끝남

### 출력값
- 각 줄마다 해당 문자열이 균형을 이루고 있는지 "yes" or "no" 출력

## 📝 코드 설계하기
(T = 입력 줄의 수, L = 해당 줄의 길이)
1. 반복문을 통해 한 줄씩 입력을 받는다. O(T)<br>
온점 하나"."일 때 반복문 종료
2. 한 줄마다 스택을 초기화한다. O(1)
3. 문자열의 문자 하나하나를 순회하며 괄호를 확인한다. O(L)<br>
여는 괄호면 스택에 push<br>
닫는 괄호면 스택이 비었거나 top이 짝이 아니면 불균형 표시하고 중단, 그게 아니면 스택에서 pop<br>
괄호가 아닌 문자는 넘김
4. 불균형이 아니고 스택이 비어 있으면 균형잡힌 문자열이면 "yes", 아니면 "no"를 출력 버퍼에 저장 O(1)
5. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(T)

총 시간 복잡도 = O(T * L의 합)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    while (true) {
      String line = br.readLine();
      if (line.equals(".")) { // 온점 하나가 나오면 입력 종료
        break;
      }

      Stack<Character> stack = new Stack<>();
      boolean balanced = true;

      for (char c : line.toCharArray()) {
        if (c == '(' || c == '[') { // 여는 괄호는 스택에 삽입
          stack.push(c);
        } else if (c == ')') { // 닫는 괄호일 때 여는 괄호가 짝을 이루는지 확인
          if (stack.isEmpty() || stack.peek() != '(') {
            balanced = false;
            break;
          }
          stack.pop();
        } else if (c == ']') { // 닫는 괄호일 때 여는 괄호가 짝을 이루는지 확인
          if (stack.isEmpty() || stack.peek() != '[') {
            balanced = false;
            break;
          }
          stack.pop();
        }
      }

      // balanced 값이 참이고 스택이 비어 있으면 균형잡힌 문자열("yes")
      if (balanced && stack.isEmpty()) {
        sb.append("yes\n");
      } else {
        sb.append("no\n");
      }
    }

    System.out.println(sb.toString());
  }
}
```