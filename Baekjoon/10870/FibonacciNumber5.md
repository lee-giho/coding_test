# 📋 피보나치 수 5
- Link<br>
https://www.acmicpc.net/problem/10870
- 풀이 날짜<br>
2025.11.02

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
n: 몇 번재 피보나치 수를 구할 것인지 (0 ≤ N ≤ 20)

### 출력값
n번째 피보나치 수 출력

## 📝 코드 설계하기
1. 몇 번째 피보나치 수를 구할 것인지 n을 입력받는다. O(1)
2. 피보나치 수 계산하는 함수를 재귀로 호출해 n번째 피보나치 수를 계산한다. O(2<sup>n</sup>)
3. n번째 피보나치 수를 출력한다. O(1)

총 시간 복잡도 = O(2<sup>n</sup>)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

   // 재귀 함수로 n번째 피보나치 수 계산
  static int fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    System.out.println(fibonacci(n));
  }
}
```