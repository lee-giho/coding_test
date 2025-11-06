# 📋 하노이 탑 이동 순서
- Link<br>
https://www.acmicpc.net/problem/11729
- 풀이 날짜<br>
2025.11.07

## 🔎 문제 탐색하기

- N = 1<br>
A
  1. 원판을 1 -> 3으로 옮기기
<br><br>

- N = 2<br>
A<br>
B
  1. A를 1 -> 2로 옮기기
  2. B를 1 -> 3으로 옮기기
  3. A를 2 -> 3으로 옮기기
<br><br>

- N = 3<br>
A<br>
B<br>
C
  
  위의 A와 B를 하나로 생각하기

  1. A와 B를 1 -> 2로 옮기기<br>
    = 원판 2개 옮기는 횟수
  2. C를 1 -> 3으로 옮기기<br>
    = 가장 큰 원판 옮기는 횟수
  3. A와 B를 2 -> 3으로 옮기기<br>
    = 원판 2개 옮기는 횟수

    따라서, 2개 옮기는 방법 + 가장 큰 거 옮기기 + 2개 옮기는 방법
<br><br>

- N개<br>
H(n) = 원판 n개를 옮기는 데 필요한 최소 이동 횟수

  1. 위의 n-1개를 1 -> 2로 옮긴다.<br>
    = H(n-1)번
  2. 가장 큰 원판을 1 -> 3으로 옮긴다.<br>
    = 1번
  3. n-1개를 2 -> 3으로 옮긴다.<br>
    = H(n-1)번

  H(n)<br>
  = H(n-1) + 1 + H(n-1)<br>
  = 2H(n-1) + 1
<br><br>

- H(1) = 1
- H(2) = 2H(1) + 1 = 2*1 + 1 = 3
- H(3) = 2H(2) + 1 = 2*3 + 1 = 7
- H(4) = 2H(3) + 1 = 2*7 + 1 = 15

따라서, H(n) = 2<sup>n</sup> - 1

### 입력값
- 첫째 줄<br>
N: 1번 장대에 쌓인 원판의 개수 (1 ≤ k ≤ 20)<br>

### 출력값
- 첫째 줄<br>
원판을 옮긴 횟수 K 출력

- 둘째 줄부터 K개의 줄
공백으로 구분된 A와 B
  - A: 몇 번째 장대에 있는 원판을 옮길지
  - B: 몇 번째 장대로 원판을 옮겼는지

## 📝 코드 설계하기
1. 원판의 개수 N을 입력받는다. O(1)
2. 최소 이동 횟수(2<sup>n</sup> - 1)를 계산한다. O(N)
3. 하노이의 탑을 계산하는 재귀 함수를 호출한다. O(2<sup>n</sup>)
    - N개의 원판을 옮기는 데 필요한 이동 횟수 = 2<sup>n</sup> - 1<br>
      재귀 호출도 위와 같이 발생
4. 각 이동을 출력 버퍼에 저장한다. O(2<sup>n</sup>)
5. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(2<sup>n</sup>)

총 시간 복잡도 = O(2<sup>n</sup>)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

  static StringBuilder sb = new StringBuilder();

  // n개의 원판을 1번(from)에서 3번(to)으로 옮기기
  // via: 2번(임시)
  static void hanoi(int n, int from, int via, int to) {
    if (n == 1) {
      sb.append(from).append(' ').append(to).append("\n");
      return;
    }

    // 위의 n-1개를 2번으로 옮긴다.
    hanoi(n - 1, from, to, via);

    // 가장 큰 원판을 1번에서 2번으로 옮긴다.
    sb.append(from).append(' ').append(to).append("\n");

    // 2번에 있는 n-1개의 원판을 3번으로 옮긴다.
    hanoi(n - 1, via, from, to);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 하노이의 탑 최소 이동 횟수를 2^N - 1로 계산
    long count = 1;
    for (int i = 0; i < N; i++) {
      count *= 2;
    }
    count -= 1;

    sb.append(count).append("\n");
    
    hanoi(N, 1, 2, 3);

    System.out.println(sb.toString());
  }
}
```