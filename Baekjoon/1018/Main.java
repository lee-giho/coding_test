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