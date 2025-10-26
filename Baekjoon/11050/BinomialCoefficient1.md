# 📋 이항 계수 1
- Link<br>
https://www.acmicpc.net/problem/11050
- 풀이 날짜<br>
2025.10.26

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 자연수 (1 ≤ N ≤ 10)<br>
K: 정수 (0 ≤ K ≤ N)

### 출력값
- $ \binom{N}{K} $ 출력.

## 📝 코드 설계하기
1. 자연수 N과 정수 K를 입력받는다. O(1)
2. 팩토리얼 계산을 통해 이항계수 공식을 계산한다. O(N)
    - N! / (K! * (N - K)!) 공식 사용
3. 계산된 결과를 출력한다. O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  // 팩토리얼 계산 함수
  static int factorial(int n) {
    int result = 1;
    for (int i = 1; i < n + 1; i++) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 자연수 N 입력
    int K = Integer.parseInt(st.nextToken()); // 정수 K 입력

    // 이항 계수 공식 적용
    int result = factorial(N) / (factorial(K) * factorial(N - K));

    System.out.println(result);
  }
}
```