import java.io.*;
import java.util.*;

public class Main {

  static int[][] bingoBoard = new int[5][5]; // 빙고판
  static HashMap<Integer, int[]> position = new HashMap<>(); // 빙고판에서의 숫자 위치
  static int calledNumTimes = 0; // 사회자가 부른 숫자의 개수
  static int bingo = 0; // 빙고가 완성된 줄의 수
  static int[] col = new int[]{0, 1, 2, 3, 4}; // 세로 방향으로 빙고 검사를 할 때 사용
  static int[] row = new int[]{0, 1, 2, 3, 4}; // 가로 방향으로 빙고 검사를 할 때 사용
  static int[] diagonal = new int[]{0, 4}; // 대각선 방향으로 빙고 검사를 할 때 사용

  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
      for (int j = 0; j < 5; j++) {
        int num = Integer.parseInt(st.nextToken()); // 빙고판에 적힌 숫자
        bingoBoard[i][j] = num; // 빙고판에 숫자 적기
        position.put(num, new int[]{i, j}); // 숫자의 위치 저장
      }
    }

    callNum: // label을 사용해 3개의 빙고가 완성됐을 때 해당 2중 for문을 멈춤
    for (int i = 0; i < 5; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
      for (int j = 0; j < 5; j++) {
        int calledNum = Integer.parseInt(st.nextToken()); // 사회자가 부른 번호
        calledNumTimes++; // 사회자가 부른 번호 개수 +1
        checkNumber(calledNum); // 사회자가 부른 번호의 위치에 0으로 바꿔서 표시
        checkBingo(); // 빙고가 됐는지 확인
        if (bingo > 2) { // 빙고가 3줄이 됐으면
          break callNum; // 사회자가 번호 부르는 거 중지
        }
      }
    }

    System.out.println(calledNumTimes);

  }

  // 사회자가 부른 번호 0으로 바꿔서 표시하는 메서드
  public static void checkNumber(int n) {
    int[] xy = position.get(n); // 빙고판에서의 숫자 위치
    int x = xy[0];
    int y = xy[1];

    bingoBoard[x][y] = 0;
  }

  // 빙고 확인하는 메서드
  public static void checkBingo() {
    if (calledNumTimes < 5) return; // 빙고가 만들어지는 최소 숫자의 개수가 5이기 때문에 만족하지 않으면 확인 X

    checkCol: // label을 사용해 해당 세로 줄이 다 0이 되지 않았을 때 다음 세로줄로 넘김
    for (int i = 0; i < col.length; i++) {
      int x = col[i];
      if (x == -1) continue; // col의 값이 -1일 경우 해당 세로줄은 이미 빙고가 된 줄이라 다음 줄로 넘김
      for (int j = 0; j < 5; j++) {
        if (bingoBoard[x][j] != 0) { // 값이 0이 아닐 경우
          continue checkCol; // 다음 세로줄로 넘김
        }
      }
      bingo++;
      col[i] = -1; // 빙고가 된 줄을 -1로 표시해서 다음에 다시 검사하지 않게 함
      if (bingo > 2) return; // 3줄 빙고가 됐을 경우 나머지 검사를 진행하지 않고 메서드 종료
    }

    checkRow: // label을 사용해 해당 가로 줄이 다 0이 되지 않았을 때 다음 가로줄로 넘김
    for (int i = 0; i < row.length; i++) {
      int y = row[i];
      if (y == -1) continue; // row의 값이 -1일 경우 해당 가로줄은 이미 빙고가 된 줄이라 다음 줄로 넘김
      for (int j = 0; j < 5; j++) {
        if (bingoBoard[j][y] != 0) { // 값이 0이 아닐 경우
          continue checkRow; // 다음 가로줄로 넘김
        }
      }
      bingo++;
      row[i] = -1; // 빙고가 된 줄을 -1로 표시해서 다음에 다시 검사하지 않게 함
      if (bingo > 2) return; // 3줄 빙고가 됐을 경우 나머지 검사를 진행하지 않고 메서드 종료
    }

    checkDiagonal: // label을 사용해 해당 대각선줄이 다 0이 되지 않았을 때 다음 대각선줄로 넘김
    for (int i = 0; i < diagonal.length; i++) {
      int xy = diagonal[i];
      if (xy == -1) continue; // diagonal의 값이 -1일 경우 해당 줄은 이미 빙고가 된 줄이라 다음 줄로 넘김
      for (int j = 0; j < 5; j++) {
        int x = j; // x 좌표
        int y = (xy == 0) ? j : 4-j; // x 좌표가 0일 경우 왼쪽 위에서 오른쪽 아래로 대각선이 이뤄지기 때문에 y = x, 나머지 4일 경우 오른쪽 위에서 왼쪽 아래로 대각선이 이뤄지기 때문에 y = 4 - x
        if (bingoBoard[x][y] != 0) { // 값이 0이 아닐 경우
          continue checkDiagonal; // 다음 가로줄로 넘김
        }
      }
      bingo++;
      diagonal[i] = -1; // 빙고가 된 줄을 -1로 표시해서 다음에 다시 검사하지 않게 함
      if (bingo > 2) return; // 3줄 빙고가 됐을 경우 나머지 검사를 진행하지 않고 메서드 종료
    }
  }
}