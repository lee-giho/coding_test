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