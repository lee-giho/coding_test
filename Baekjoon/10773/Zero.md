# 📋 제로
- Link<br>
https://www.acmicpc.net/problem/10773
- 풀이 날짜<br>
2025.09.10

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
K: 입력받을 정수의 수 (1 ≤ K ≤ 100,000)
- 둘째 줄부터 K개의 줄<br>
num: 정수 (0 ≤ num ≤ 1,000,000)

### 출력값
- 최종적으로 저장되어 있는 수의 합

## 📝 코드 설계하기
1. 입력받을 정수의 수인 K를 입력받는다. O(1)
2. 사용할 변수를 초기화한다. O(1)
3. K번 반복하며 정수를 입력받아 처리를 반복한다. O(K)<br>
입력받은 수가 0이면 스택에서 pop을 해 최근 값을 제거한다.<br>
입력받은 수가 0이 아니면 스택에 push한다.
4. 스택이 빌 때까지 pop을 하며 값을 다 더한다. O(K)
5. 정수의 합을 출력한다. O(1)

총 시간 복잡도 = O(K)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int K = Integer.parseInt(br.readLine()); // 입력받을 정수의 개수 K

    int sum = 0; // 최종 합계
    Deque<Integer> stack = new ArrayDeque<>(); // 입력값 관리를 위한 스택
    
    // K번 반복하며 정수 입력 처리
    for (int i = 0; i < K; i++) {
      int num = Integer.parseInt(br.readLine());

      if (num == 0) { // 0이 입력되면
        stack.pop(); // 최근 값 제거
      } else {
        stack.push(num);
      }
    }

    // 스택의 모든 값 더하기
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }

    System.out.println(sum);
  }
}
```