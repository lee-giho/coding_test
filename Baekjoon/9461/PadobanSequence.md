# 📋 파도반 수열
- Link<br>
https://www.acmicpc.net/problem/9461
- 풀이 날짜<br>
2025.09.21

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
T: 테스트 케이스의 개수

- 둘째 줄부터 T개의 줄<br>
N: 몇 번째 값을 구할 것인지 (1 ≤ N ≤ 100)

### 출력값
- 각 테스트 케이스의 P[N] 값 출력<br>

### 규칙 찾기
| **N** | **P[N] 값** |
| :---: | :--- |
| 1 | 1 |
| 2 | 1 |
| 3 | 1 |
| 4 | 1 + 1 = 2 |
| 5 | 1 + 1 = 2 |
| 6 | 1 + 2 = 3 |
| 7 | 2 + 2 = 4 |
| 8 | 2 + 3 = 5 |
| 9 | 3 + 4 = 7 |
| 10 |4 + 5 = 9 |

따라서 P[N] = P[N-3] + P[N-2]

## 📝 코드 설계하기
1. 테스트 케이스의 개수 T를 입력받는다. O(1)
2. 배열 P를 정의하고 1 ~ 3까지 값을 1로 초기화한다. O(1)
3. 점화식 P[N] = P[N-3] + P[N-2]을 통해 4 ~ 100까지 계산한다. O(100)
4. 각 테스트 케이스마다 N을 입력받아 P[N]을 출력 버퍼에 추가한다. O(1)
5. 출력 버퍼에 저장된 각 케이스 별 P[N] 값을 출력한다. O(1)

총 시간 복잡도 = O(100 + T)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 T 입력

    // 파도반 수열인 P 배열 초기화 및 3까지 입력
    long[] P = new long[101];
    P[1] = P[2] = P[3] = 1;

    // 점화식으로 4 ~ 100 계산
    // P[N] = P[N-3] + P[N-2]
    for (int i = 4; i < 101; i++) {
      P[i] = P[i-3] + P[i-2];
    }

    // 각 테스트 케이스의 값 처리
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      sb.append(P[N]).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```