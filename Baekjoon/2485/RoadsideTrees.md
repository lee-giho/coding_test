# 📋 가로수
- Link<br>
https://www.acmicpc.net/problem/2485
- 풀이 날짜<br>
2025.10.09

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 이미 심어져 있는 가로수의 수 (3 ≤ N ≤ 100,000)

- 둘째 줄부터 N개의 줄<br>
position: 심어져 있는 가로수의 위치 (1 ≤ position ≤ 1,000,000,000)

### 출력값
- 모든 가로수가 같은 간격이 되도록 새로 심어야 하는 가로수의 최소 수 출력

## 📝 코드 설계하기
1. 심어져 있는 가로수의 수 N과 가로수의 위치 position을 입력받는다. O(N)
2. 인접 가로수의 간격을 계산한다. O(N)
3. 간격들의 최대공약수를 계산한다. O(N log M)
4. 각 간격에서 필요한 가로수의 수를 더한다. O(N)
5. 심어야 하는 가로수의 최소 수를 출력한다. O(1)

총 시간 복잡도 = O(N log M)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

  // 유클리드 호제법으로 최대공약수 구하기
  static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 이미 심어져 있는 가로수의 수 N 입력

    // 심어져 있는 가로수의 위치 position 입력
    int[] position = new int[N];
    for (int i = 0; i < N; i++) {
      position[i] = Integer.parseInt(br.readLine());
    }

    // 인접한 가로수의 간격 계산
    int[] gaps = new int[N-1];
    for (int i = 0; i < N-1; i++) {
      gaps[i] = position[i+1] - position[i];
    }

    // 모든 간격의 최대공약수 구하기
    int GCD = gaps[0];
    for (int i = 1; i < gaps.length; i++) {
      GCD = gcd(GCD, gaps[i]);
    }

    // 추가해야 할 가로수의 수 더하기
    long count = 0;
    for (int gap : gaps) {
      count += (gap / GCD) - 1;
    }

    System.out.println(count);
  }
}
```