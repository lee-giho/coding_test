# 📋 체스판 다시 칠하기
- Link<br>
https://www.acmicpc.net/problem/1018
- 풀이 날짜<br>
2025.09.17

## 🔎 문제 탐색하기

### 입력값
- 첫째 줄<br>
N: 보드의 행 개수 (8 ≤ N ≤ 50)

- 둘째 줄<br>
M: 보드의 열 개수 (8 ≤ N ≤ 50)

- 셋째 줄부터 N개의 줄<br>
보드의 각 행의 상태<br>
B: 검은색<br>
W: 흰색

### 출력값
- 다시 칠해야 하는 정사각형 개수의 최솟값 출력

## 📝 코드 설계하기
1. 행의 개수 N과 열의 개수 M을 입력받는다. O(1)
2. N개의 문자열을 입력받아 배열에 저장한다. O(NM)
3. 반복문을 통해 8x8 체스판을 검사한다. O(NM)
4. 다시 칠해야 하는 정사각형 개수를 계산한다. O(1)
5. 다시 칠해야 하는 정사각형 개수를 출력한다. O(1)

총 시간 복잡도 = O(NM)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int answer = Integer.MAX_VALUE; // 다시 칠해야 하는 정사각형 개수의 최솟값

    int N = Integer.parseInt(st.nextToken()); // 행의 개수 N
    int M = Integer.parseInt(st.nextToken()); // 열의 개수 M

    // 체스판 문자 입력 (B, W)
    char[][] board = new char[N][M];
    for (int i = 0; i < N; i++) {
      String line = br.readLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = line.charAt(j);
      }
    }

    for (int i = 0; i <= N-8; i++) {
      for (int j = 0; j <= M-8; j++) {

        int repaintW = 0; // 왼쪽 위가 W 패턴으로 맞추기 위해 칠해야 하는 정사각형의 수

        for (int r = 0; r < 8; r++) {
          for (int c = 0; c < 8; c++) {
            char expected = ((r + c) % 2 == 0) ? 'W' : 'B'; // 시작이 W이면 짝수:W, 홀수:B
            if (board[i + r][j + c] != expected) { // 기대 색과 다르면 repaintW 증가
              repaintW++;
            }
          }
        }

        int repaintB = 64 - repaintW; // B로 시작하는 패턴에서 다시 칠해야 하는 정사각형의 수는 64 - repaintW와 같다
        
        // 해당 8x8에서 최소 칠하기 수
        int localMin = Math.min(repaintW, repaintB);
        if (localMin < answer) {
          answer = localMin;
        }
      }
    }

    System.out.println(answer);
  }
}
```