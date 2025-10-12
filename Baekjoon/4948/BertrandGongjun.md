# 📋 베르트랑 공준
- Link<br>
https://www.acmicpc.net/problem/4948
- 풀이 날짜<br>
2025.10.12

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄부터 0이 입력되기 전까지<br>
테스트 케이스에 대한 임의의 자연수 n

### 출력값
- 각 테스트 케이스에 대해 n보다 크고 2n보다 작거나 같은 소수의 개수 출력

## 📝 코드 설계하기
(T = 입력 줄 수, N = n들 중 최대값)
1. 여러 줄을 입력 받으며 0이 나올 때까지 리스트에 저장한다. O(T)
2. 입력된 n 중 최대값을 구하고 소수를 판별할 배열을 만든다. O(1)
3. 에라토스테네스의 체를 구현해 소수가 아닌 수를 제거한다. O(N log log N)
4. 배열을 만들어 소수의 개수를 구한다. O(N)
5. 각 테스트 케이스에 대해 (n, 2n] 범위의 소수 개수를 계산하고 출력한다. O(T)

총 시간 복잡도 = O(N log log N + T)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    List<Integer> inputs = new ArrayList<>(); // 입력된 n 저장할 리스트

    // 여러 줄 입력받으며 0이 될 때까지 리스트에 저장
    int n;
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      inputs.add(n);
    }

    int MaxN = Collections.max(inputs); // n들 중 최대값
    int limit = MaxN * 2; // 소수 판별 범위

    // 에라토스테네스의 체를 위한 배열 초기화
    boolean[] isPrime = new boolean[limit+1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    // 에라토스테네스의 체를 통해 i의 배수 제거
    for (int i = 2; i * i < limit + 1; i++) {
      if (isPrime[i]) {
        for (int j = i * i;  j < limit + 1; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // 소수 개수 전처리
    int[] primeCount = new int[limit + 1];
    for (int i = 1; i < limit + 1; i++) {
      primeCount[i] = primeCount[i - 1] + (isPrime[i] ? 1 : 0);
    }

    // 각 n마다 (2, 2n] 구간의 소수 개수 계산
    for (int num : inputs) {
      int count = primeCount[num * 2] - primeCount[num];
      sb.append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```