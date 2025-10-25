# 📋 팩토리얼
- Link<br>
https://www.acmicpc.net/problem/10872
- 풀이 날짜<br>
2025.10.25

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 팩토리얼 값을 구할 정수 (0 ≤ N ≤ 12)

### 출력값
- 정수 N의 팩토리얼 값 출력

## 📝 코드 설계하기
1. 정수 N을 입력받는다. O(1)
2. 반복문을 통해 1부터 N까지 곱한다. O(N)
3. N 팩토리얼의 값을 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 정수 N 입력

    int result = 1; // 팩토리얼 계산을 위한 초기값

    // 1부터 N까지 곱하며 팩토리얼 계산
    for (int i = 1; i < N + 1; i++) {
      result *= i;
    }

    System.out.println(result);
  }
}
```