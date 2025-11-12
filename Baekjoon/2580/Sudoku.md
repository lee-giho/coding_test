# 📋 스도쿠
- Link<br>
https://www.acmicpc.net/problem/2580
- 풀이 날짜<br>
2025.11.12

## 🔎 문제 탐색하기

- 빈 칸의 위치를 확인한다.
- 빈 칸을 앞에서부터 DFS로 채워나간다.
- 숫자를 넣을 수 있는지 확인하기 위해 열, 행 , 박스를 boolean 값으로 저장해 관리한다.

### 입력값
- 아홉 줄에 걸쳐 한 줄에 9개씩 공백으로 구분되어 입력 (0 ~ 9) <br>
  - 0: 빈칸
  - 1 ~ 9: 스도쿠 판에 이미 적혀있는 숫자

### 출력값
- 모든 빈 칸이 채워진 스도쿠 판을 아홉 줄에 걸쳐 한 줄에 9개씩 공백으로 구분해 출력<br>


## 📝 코드 설계하기
(b = blank, 빈칸의 수)
1. 문제에서 주는 스도쿠 판을 배열에 입력하고 빈 칸을 확인한다. O(1)
2. DFS로 빈칸에 해당하는 숫자를 찾는다. O(9<sup>b</sup>)
    - 1 ~ 9까지 숫자를 하나씩 시도한다.
    - 각 숫자
      - 행, 열, 박스에 대해 가능한 숫자인지 확인
      - 가능하면 해당 숫자를 넣고 다음 빈칸으로 재귀 호출
      - 불가능하거나 재귀가 실패하면 빈칸 및 상태를 원래대로 돌린다.
3. 완성된 스도쿠를 아홉 줄에 걸쳐 한 줄에 9개씩 공백으로 구분해 출력한다. O(1)

총 시간 복잡도 = O(9<sup>b</sup>)

## ✅ 정답 코드
```java
import java.io.*;
import java.util.*;

public class Main {

  static int[][] board = new int[9][9];
  static boolean[][] row = new boolean[9][10];
  static boolean[][] col = new boolean[9][10];
  static boolean[][] box = new boolean[9][10];
  static List<int[]> blanks = new ArrayList<>();
  static boolean solved = false;
  
  // (r, c)가 속한 3 x 3 박스의 번호(0 ~ 8)
  static int boxIndex(int r, int c) {
    return (r / 3) * 3 + (c / 3);
  }

  // idx번째 빈칸 채우는 재귀 함수
  static void dfs(int idx) {
    // 답을 찾은 경우
    if (solved) return;

    // 모든 빈칸을 채운 경우
    if (idx == blanks.size()) {
      solved = true;
      return;
    }

    int[] pos = blanks.get(idx);
    int r = pos[0];
    int c = pos[1];
    int b = boxIndex(r, c);

    // 1부터 9까지 가능한 숫자 시도
    for (int num = 1; num <= 9; num++) {
      // 같은 열, 행, 박스에 이미 num이 있으면 넘기기
      if (row[r][num] || col[c][num] || box[b][num]) continue;

      board[r][c] = num;
      row[r][num] = col[c][num] = box[b][num] = true;

      dfs(idx + 1);

      // 답을 찾은 경우
      if (solved) return;

      board[r][c] = 0;
      row[r][num] = col[c][num] = box[b][num] = false;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 스도쿠 판 입력 및 상태 초기화
    for (int r = 0; r < 9; r++) {
      StringTokenizer st= new StringTokenizer(br.readLine());
      for (int c = 0; c < 9; c++) {
        int v = Integer.parseInt(st.nextToken());
        board[r][c] = v;

        if (v == 0) { // 0이면 빈칸 위치 저장
          blanks.add(new int[]{r, c});
        } else { // 0이 아니면 이미 채워져 있는 숫자
          row[r][v] = true;
          col[c][v] = true;
          box[boxIndex(r, c)][v] = true;
        }
      }
    }

    // 첫 번째 빈칸부터 시작
    dfs(0);

    StringBuilder sb = new StringBuilder();
    for (int r = 0; r < 9; r++) {
      for (int c = 0; c < 9; c++) {
        sb.append(board[r][c]).append(' ');
      }
      sb.append('\n');
    }
    System.out.println(sb.toString());
  }
}
```