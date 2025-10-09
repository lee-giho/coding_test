# 📋 분수 합
- Link<br>
https://www.acmicpc.net/problem/1735
- 풀이 날짜<br>
2025.10.09

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 분자 A와 분모 B (1 ≤ A, B ≤ 30,000)

- 둘째 줄<br>
공백으로 구분된 분자 C와 분모 D (1 ≤ C, D ≤ 30,000)

### 출력값
- 기약분수의 분자와 분모를 공백으로 구분해 출력

## 📝 코드 설계하기
1. 분수 A/B와 C/D를 입력받는다. O(1)
2. 분수 합을 계산한다. O(1)
3. 유클리드 호제법을 통해 최대공약수를 구한다. O(log(min(분자, 분모)))
4. 분자와 분모를 최대공약수로 나눠 기약분수로 만든다. O(1)
5. 구한 기약분수를 출력한다. O(1)

총 시간 복잡도 = O(log(min(분자, 분모)))

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  // 유클리드 호제법으로 최대공약수 구하기
  static long gcd(long a, long b) {
    while (b != 0) {
      long temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 첫 번째 분수 A/B 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    // 두 번째 분수 C/D 입력
    st = new StringTokenizer(br.readLine());
    long C = Long.parseLong(st.nextToken());
    long D = Long.parseLong(st.nextToken());

    long num = A * D + C * B; // 분자
    long den = B * D; // 분모

    // 기약분수로 만들기 위해 최대공약수로 나누기
    long g = gcd(Math.abs(num), den);
    num /= g;
    den /= g;

    System.out.println(num + " " + den);
  }
}
```