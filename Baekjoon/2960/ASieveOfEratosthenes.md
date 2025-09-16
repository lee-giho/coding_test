# 📋 에라토스테네스의 체
- Link<br>
https://www.acmicpc.net/problem/2960
- 풀이 날짜<br>
2025.09.15

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
공백으로 구분된 N과 K (1 ≤ K < N, max(1, K) < N ≤ 1000)<br>
N: 지울 숫자의 범위 (1 ~ N)<br>
K: 몇 번째 수를 지울 건지

### 출력값
- K번째로 지워진 수 출력

## 📝 코드 설계하기
1. 지울 숫자의 범위와 몇 번째 수를 지울건지에 대한 N과 K를 입력받는다. O(1)
2. 지워진 숫자인지 나타내는 배열 초기화 O(N)
3. 반복문을 통해 p= 2 ... N 범위로 시뮬레이션을 수행한다. O(N log log N)<br>
removed[p]가 false일 때 배수 지우기<br>
이미 지워진 수는 건너뛰기
4. K번째 지워진 수 출력하기 O(1)

총 시간 복잡도 = O(N log log N)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 지울 숫자의 범위 (1 ~ N)
    int K = Integer.parseInt(st.nextToken()); // 몇 번째 수를 지울 건지

    boolean[] removed = new boolean[N+1]; // 지워진 숫자 확인을 위한 배열
    int count = 0; // 몇 번째로 지워졌는지

    for (int p = 2; p < N+1; p++) {
      if (removed[p]) { // 이미 지워졌다면 건너뛰기
        continue;
      }

      // p의 배수를 작은 것부터 지우기
      for (int m = p; m < N+1; m += p) {
        if (!removed[m]) { // 지워지지 않았다면
          removed[m] = true; // 지우고 
          count++; // 횟수 증가
          if (count == K) { // K번째로 지워진 수면 출력 후 종료
            System.out.println(m);
            return;
          }
        }
      }
    }
  }
}
```