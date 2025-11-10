# 📋 N-Queen
- Link<br>
https://www.acmicpc.net/problem/9663
- 풀이 날짜<br>
2025.11.11

## 🔎 문제 탐색하기

한 행에 퀸 하나씩만 배치한다고 가정했을 때, 각 행에서 퀸을 놓을 수 있는 열만 고려

### 입력값
- 첫째 줄<br>
N (1 ≤ N ≤ 15)<br>

### 출력값
- 첫째 줄<br>
퀸 N개를 서로 공격할 수 없게 놓는 경우의 수 출력

## 📝 코드 설계하기
1. N을 입력받는다. O(1)
2. 퀸의 열 위치를 저장할 col을 N 크기로 초기화 한다. O(1)
3. dfs로 퀸 배치 O(N!)
    - 각 행마다 가능한 열 탐색
    - 유효성 검사로 퀸들이 공격 가능한지 확인
      - 이전 행들과 열과 대각선 방향으로 공격되는지
    - 가능하면 재귀 호출을 통해 다음 행 확인
4. 모든 행에 퀸이 배치되면 카운트 증가 O(1)
5. 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수 출력 O(1)

총 시간 복잡도 = O(N!)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

  static int N;
  static int[] col; // 퀸의 위치 저장
  static int count = 0; // N개의 퀸을 놓을 수 있는 경우의 수

  // 퀸들이 서로 공격하지 못하는 자리인지 검사
  static boolean isPossible(int row) {
    for (int i = 0; i < row; i++) {
      if (col[i] == col[row] || Math.abs(col[i] - col[row]) == row - i) {
        return false;
      }
    }
    return true;
  }

  static void dfs(int row) {
    // 모든 행에 퀸을 배치한 경우
    if (row == N) {
      count++;
      return;
    }

    for (int c = 0; c < N; c++) {
      col[row] = c;
      if (isPossible(row)) {
        dfs(row + 1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    col = new int[N];

    dfs(0); // 0번째 행부터 퀸 배치

    System.out.println(count);
  }
}
```