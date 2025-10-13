# 📋 골드바흐 파티션
- Link<br>
https://www.acmicpc.net/problem/17103
- 풀이 날짜<br>
2025.10.13

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
테스트 케이스 개수 T (1 ≤ T ≤ 100)

- 둘째 줄부터 T개의 줄<br>
짝수인 정수 N (2 < N ≤ 1,000,000)

### 출력값
- 한 줄에 한 테스트 케이스의 골드바흐 파티션의 수 출력

## 📝 코드 설계하기
1. 테스트 케이스 개수 T를 입력받고, 짝수 N을 리스트에 저장한다. O(T)
2. 입력된 N 중 최대값을 구하고, N 크기의 배열을 만든다. O(1)
3. 에라토스테네스의 체를 이용해 배수를 제거하며 소수를 구한다. O(N log log N)
4. 각 테스트 케이스마다 N을 두 소수의 합으로 표현할 수 있는 경우의 수를 구한다. O(N/2)
5. 테스트 케이스에 대해 결과를 출력 버퍼에 저장하고 한 번에 출력한다. O(T)

총 시간 복잡도 = O(N log log N + N/2)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  // 에라토스테네스의 체로 [0, limit] 범위 소수 반환
  static boolean[] sieve(int limit) {
    boolean[] prime = new boolean[limit + 1];
    Arrays.fill(prime, true);
    if (limit >= 0) prime[0] = false;
    if (limit >= 1) prime[1] = false;

    for (int i = 2; i * i < limit + 1; i++) {
      if (prime[i]) {
        for (int j = i * i; j < limit + 1; j += i) {
          prime[j] = false;
        }
      }
    }
    return prime;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
    int[] queries = new int[T]; // 짝수 n을 입력받을 배열
    int maxN = 0;

    // 짝수 n 입력받기
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      queries[t] = N;
      if (N > maxN) {
        maxN = N;
      }
    }

    // 소수 전처리
    boolean[] isPrime = sieve(maxN);

    // 각 짝수 n에 대해 골드바흐 파티션 수 계산
    for (int n : queries) {
      int half = n / 2;
      int count = 0;
      for (int p = 2; p < half + 1; p++) {
        if (isPrime[p] && isPrime[n - p]) {
          count++;
        }
      }
      sb.append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```