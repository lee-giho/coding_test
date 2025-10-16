# 📋 도키도키 간식드리미
- Link<br>
https://www.acmicpc.net/problem/12789
- 풀이 날짜<br>
2025.10.17

## 🔎 문제 탐색하기

- 1번부터 N번까지 학생이 순서대로 간식을 받는지 확인하고 싶음
- 앞 사람이 자신의 차례보다 이른 번호면 통과하고 더 큰 번호면 스택에 대기
- 모두 순서대로 받을 수 있으면 "Nice", 아니면 "Sad"

### 입력값
- 첫째 줄<br>
N: 승환이 앞에 서 있는 학생들의 수 (1 ≤ N ≤ 1,000)

- 둘째 줄<br>
공백으로 구분된 모든 학생들의 번호표

### 출력값
- 승환이가 간식을 무사히 받을 수 있으면 "Nice", 아니면 "Sad" 출력

## 📝 코드 설계하기
1. 줄에 서 있는 학생 수 N을 입력 받는다. O(1)
2. 줄에 서 있는 학생들의 번호표를 입력 받는다. O(N)
3. 임시 대기 공간인 스택과 현재 순서를 초기화한다. O(1)
4. 반복문을 통해 줄에 선 순서대로 간식을 받는지 확인하며 처리한다. O(N)
5. 임시 대기 공간인 스택에 값이 남아있는지 확인하고 결과를 출력한다. O(1)
    - 스택이 비어 있으면 "Nice"
    - 스택이 비어 있지 않으면 "Sad"

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 학생 수 N 입력
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 줄에 서 있는 학생들의 번호 저장
    int[] waiting = new int[N];
    for (int i = 0; i < N; i++) {
      waiting[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> stack = new Stack<>(); // 임시 대기 공간
    int order = 1; // 받아야 하는 다음 학생 번호

    // 줄에 서 있는 순서대로
    for (int num : waiting) {
      if (num == order) { // 지금 서 있는 학생이 간식을 받을 차례면
        order++; // 간식 받고 다음 번호로
      } else { // 아니면 임시 대기 공간으로 이동
        stack.push(num);
      }

      // 임시 대기 공간의 top이 현재 차례면
      while (!stack.isEmpty() && stack.peek() == order) {
        stack.pop(); // 간식 받고
        order++; // 다음 번호로
      }
    }

    if (stack.isEmpty()) { // 모든 학생이 순서대로 간식을 받았다면
      System.out.println("Nice");
    } else { // 순서대로 간식을 받지 못해 모든 학생이 받지 못했다면
      System.out.println("Sad");
    }
  }
}
```