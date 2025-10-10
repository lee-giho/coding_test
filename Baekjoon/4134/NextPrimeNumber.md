# 📋 다음 소수
- Link<br>
https://www.acmicpc.net/problem/4134
- 풀이 날짜<br>
2025.10.10

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 테스트 케이스의 개수

- 둘째 줄부터 T개의 줄<br>
n: 크거나 같은 소수 중 가장 작은 소수를 찾을 정수 n(0 ≤ n ≤ 4*10<sup>9</sup>)

### 출력값
- 한 줄에 하나의 테스트 케이스에 대해 n보다 크거나 같은 소수 중 가장 작은 소수 출력

## 📝 코드 설계하기
(k = n이 증가한 횟수)
1. 테스트 케이스 개수 T를 입력받는다. O(1)
2. 각 테스트 케이스마다 정수 n을 입력받는다. O(T)
3. n 이상인 수 중 첫 첫 번째 소수를 찾기 위해 isPrime(n) 함수를 만들어 검사한다. O(√n)
4. 소수가 아니면 n++ 하며 반복한다. O(k√n)
5. 찾은 소수를 출력 버퍼에 저장한다. O(1)
6. 출력 버퍼에 저장된 문자열을 출력한다. O(1)

총 시간 복잡도 = O(k√n)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

  // 소수 확인하는 함수
  static boolean isPrime(long n) {
    if (n < 2) return false; // 0과 1은 소수 X
    if (n == 2) return true; // 2는 소수
    if (n % 2 == 0) return false; // 짝수는 소수 X

    long sqrt = (long) Math.sqrt(n);
    for (long i = 3; i <= sqrt; i += 2) {
      if (n % i == 0) return false; // 나누어떨어지면 합성수
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      long n = Long.parseLong(br.readLine());
      while (!isPrime(n)) { // n이 소수가 될 때까지 증가
        n++;
      }
      sb.append(n).append("\n");
    }
    
    System.out.println(sb.toString());
  }
}
```