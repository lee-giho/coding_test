# 📋 별 찍기 - 10
- Link<br>
https://www.acmicpc.net/problem/2447
- 풀이 날짜<br>
2025.11.06

## 🔎 문제 탐색하기

- N == 1이면<br>
  '*' 출력하고 종료
- N > 1이면<br>
  정사각형을 3x3으로 나눈다. 크기는 N/3<br>
  전체적으로 봤을 때 9칸 중 정중앙는 공백으로 비운다.<br>
  나머지 테두리인 8칸은 재귀 함수를 통해 같은 패턴을 그린다.<br>
  N이 1이 될 때까지 반복한다.

### 입력값
- 첫째 줄<br>
N: 3의 거듭제곱, N=3<sup>k</sup> (1 ≤ k < 8)<br>

### 출력값
첫째 줄부터 N번째 줄까지 별 출력

## 📝 코드 설계하기
1. 패턴을 그릴 정수 N을 입력받는다. O(1)
2. 패턴을 그릴 2차원 배열을 공백으로 초기화한다. O(N<sup>2</sup>)
3. 재귀함수를 통해 별을 입력한다. O(N<sup>2</sup>)
4. 배열을 한 행씩 출력 버퍼에 저장한다. O(N<sup>2</sup>)
5. 출력 버퍼에 저장된 문자열을 한 번에 출력한다. O(N<sup>2</sup>)

총 시간 복잡도 = O(N<sup>2</sup>)

## ✅ 정답 코드
```java
import java.io.*;

public class Main {

  static char[][] board; // 패턴을 그릴 2차원 배열

  // 패턴을 그리는 재귀 함수
  static void drawSquare(int x, int y, int n) {
    if (n == 1) {
      board[x][y] = '*';
      return;
    }

    int size = n / 3; // 한 블럭의 크기

    // 3 x 3으로 순회
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == 1 && j == 1) continue; // 가운데 부분 공백으로 처리

        drawSquare(x + i * size, y + j * size, size); // 나머지 블럭 재귀로 패턴 그리기
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine()); // 패턴을 그릴 정수

    // 배열을 공백으로 초기화
    board = new char[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        board[i][j] = ' ';
      }
    }

    // 처음부터 시작해 패턴 그리기
    drawSquare(0, 0, N);
  
    for (int i = 0; i < N; i++) {
      sb.append(board[i]).append("\n");
    }

    System.out.println(sb.toString());
  }
}
```