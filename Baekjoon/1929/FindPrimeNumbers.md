# 📋 소수 구하기
- Link<br>
https://www.acmicpc.net/problem/1929
- 풀이 날짜<br>
2025.10.11

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 자연수 M과 N (1 ≤ M ≤ N ≤ 1,000,000)

### 출력값
- 한 줄에 하나씩 증가하는 순서대로 소수 출력

## 📝 코드 설계하기
1. 공백으로 구분된 자연수 M과 N을 입력받는다. O(1)
2. N+1 크기의 배열 생성 후 true로 채운다. O(N)
3. 에라토스테네스의 체를 구현해 수행한다. O(N log log N)
4. 반복문을 통해 출력 버퍼에 소수를 저장한다. O(N)
5. 출력 버퍼에 저장된 문자열을 출력한다. O(1)

총 시간 복잡도 = O(N log log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true); // 처음에 모든 수를 소수라고 가정
    isPrime[0] = false;
    isPrime[1] = false;

    // 에라토스테네스의 체
    for (int i = 2; i*i < N+1; i++) {
      if (isPrime[i]) {
        for (int j = i*i; j < N+1; j += i) {
          isPrime[j] = false; // 배수는 소수 X
        }
      }
    }

    // M 이상 N 이하의 소수 출력
    for (int i = M; i < N+1; i++) {
      if (isPrime[i]) {
        sb.append(i).append("\n");
      }
    }

    System.out.println(sb.toString());
  }
}
```