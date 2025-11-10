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