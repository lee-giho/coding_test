# 📋 2×n 타일링
- Link<br>
https://www.acmicpc.net/problem/11726
- 풀이 날짜<br>
2025.09.18

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
n: 타일을 채울 가로 길이 (1 ≤ n ≤ 1,000)

### 출력값
- 2xn 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지 값 출력

### 규칙 찾기
- n = 1<br>
dp[1] = 1<br>
(세로1)

- n = 2<br>
dp[2] = 2<br>
(세로2), (가로2)

- n = 3<br>
dp[3] = 3<br>
(세로3), (세로1 + 가로2), (가로2, 세로1)

- n = 4<br>
d[4] = 5<br>
(세로4), (가로2 + 가로2), (가로2 + 세로2), (세로2, 가로2), (세로1 + 가로2 + 세로1)

- n = 5<br>
dp[5] = 8<br>
(세로5), (가로2 + 세로3), (세로1 + 가로2 + 가로2), (세로2 + 가로2 + 세로1), (세로3 + 가로2), (가로2 + 가로2 + 세로), (가로2 + 세로1 + 가로2), (세로 + 가로2 + 가로2)

따라서 dp[n] = dp[n-1] + d[n-2]

## 📝 코드 설계하기
1. 타일을 채울 가로 길이 n을 입력받는다. O(1)
2. n = 1과 n = 2일 때, dp 배열 값을 각각 1과 2로 초기화한다. O(1)
3. 3부터 n까지 반복문을 통해 dp[i] = (dp[i-1] + dp[i-2]) % 10007을 계산한다. O(n)
4. n일 때의 값인 dp[n]을 출력한다. O(1)

총 시간 복잡도 = O(n)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 타일을 채울 가로 길이 n
    final int MOD = 10007; // 문제에서 요구한 나머지 연산 값

    // n = 1, n = 2일 때, 바로 답 출력 후 종료
    if (n < 3) {
      System.out.println(n);
      return;
    }

    int[] dp = new int[n+1];
    dp[1] = 1; // 2x1 보드를 채우는 경우: 세로 1
    dp[2] = 2; // 2x2 보드를 채우는 경우: 세로2 or 가로2

    // dp[i] = dp[i-1] + dp[i-2]
    for (int i = 3; i < n+1; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % MOD;
    }

    System.out.println(dp[n]);
  }
}
```