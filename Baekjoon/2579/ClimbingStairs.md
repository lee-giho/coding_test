# 📋 계단 오르기
- Link<br>
https://www.acmicpc.net/problem/2579
- 풀이 날짜<br>
2025.09.19

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 계단의 개수 (1 ≤ N ≤ 300)

- 둘째 줄부터 N개의 줄
score: 계단에 쓰여 있는 점수 (1 ≤ score ≤ 10,000)

### 출력값
- 계단 오르기 게임에서 얻을 수 있는 점수의 최댓값

### 규칙
1. 한 번에 한 칸 또는 두 칸 오르기 가능
2. 연속으로 세 번 한 칸 오르기 불가능<br>
시작 계단 제외
3. 마지막 계단은 반드시 밟아야 함

### 규칙 찾기
| **N** | **가능한 계단 오르기** | **dp 값** |
| :---: | :--- | :--- |
| 1 | (1) | dp[1] = score[1] |
| 2 | (1 -> 2) | dp[2] = score[1] + score[2] |
| 3 | (1 -> 3) or (2 -> 3) | dp[3] = max(score[1] + score[3], score[2] + score[3]) | 
| 4 | (2 -> 4) or (1 -> 3 -> 4) | dp[4] = max(dp[2] + score[4], dp[1] + score[3] + score[4]) |
| 5 | (3 -> 5) or (2 -> 4 -> 5) | dp[5] = max(dp[3] + score[5], dp[2] + score[4] + score[5]) |

따라서 dp[N] = max(dp[N-2] + score[N], dp[N-3] + score[N-1] + score[N])

## 📝 코드 설계하기
1. 계단 개수 N을 입력받는다. O(1)
2. 각 계단에 적힌 점수를 score 배열에 저장한다. O(N)
3. 예외 처리 및 초기 dp 초기화 O(1)
- N이 1과 2일 때 예외처리
- N이 3 이상이라면 3까지 DP 배열 초기화
4. 점화식 적용하여 N까지 최대 점수 구하기 O(N)
5. 최대 점수 출력 O(1)

총 시간 복잡도 = O(N)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 계단 개수 입력

    // 각 계단의 점수 입력
    int[] score = new int[N+1];
    for (int i = 1; i < N+1; i++) {
      score[i] = Integer.parseInt(br.readLine());
    }

    // 계단 개수가 2 이하일 때 예외 처리
    if (N == 1) {
      System.out.println(score[1]);
      return;
    }
    if (N == 2) {
      System.out.println(score[1] + score[2]);
      return;
    }

    // 계단 개수가 3 이상일 때 dp 배열 초기화
    int[] dp = new int[N+1];
    dp[1] = score[1];
    dp[2] = score[1] + score[2];
    dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

    // 점화식 적용
    // dp[N] = max(dp[N-2] + score[N], dp[N-3] + score[N-1] + score[N])
    for (int i = 4; i < N+1; i++) {
      dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
    }

    System.out.println(dp[N]);
  }
}
```