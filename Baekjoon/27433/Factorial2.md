# 📋 팩토리얼 2
- Link<br>
https://www.acmicpc.net/problem/27433
- 풀이 날짜<br>
2025.11.01

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 외울 단어의 길이 (0 ≤ N ≤ 20)

### 출력값
계산된 N! 출력

## 📝 코드 설계하기
1. 팩토리얼 값을 계산할 정수 N을 입력받는다. O(1)
2. 팩토리얼 계산 함수를 재귀로 호출해 N!의 값을 계산한다. O(N)
3. N! 값을 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

  // 재귀 함수로 팩토리얼 계산
  static long factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    System.out.println(factorial(N));
  }
}
```