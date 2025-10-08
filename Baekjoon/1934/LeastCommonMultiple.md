# 📋 최소공배수
- Link<br>
https://www.acmicpc.net/problem/1934
- 풀이 날짜<br>
2025.10.08

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 테스트 케이스 개수 (1 ≤ T ≤ 1,000)

- 둘째 줄부터 T개의 줄<br>
공백으로 구분된 자연수 A와 B (1 ≤ A, B ≤ 45,000)

### 출력값
- T개의 줄에 각 테스트 케이스의 최소공배수 출력

## 📝 코드 설계하기
1. 테스트 케이스의 수 T를 입력받는다. O(1)
2. 각 테스트 케이스마다 정수 A와 B를 입력받는다. O(T)
3. 유클리드 호제법을 통해 최대공약수를 구한다. O(log(min(A, B)))
4. A * B / GCD를 통해 최소공배수를 구한다. O(1)
5. 결과를 출력 버퍼에 저장하고 한 번에 출력한다. O(1)

총 시간 복잡도 = O(T log(min(A, B)))

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static int getGCD(int a, int b) { // 최대 공약수 계산 함수
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken()); // 자연수 A 입력
      int B = Integer.parseInt(st.nextToken()); // 자연수 B 입력

      int gcd = getGCD(A, B); // 최대공약수 게산
      long lcm = (long) A * B / gcd; // 최소공배수 계산
      sb.append(lcm).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```