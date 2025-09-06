import java.io.*;

public class Main {
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 방의 크기 N 입력받기
    int row = 0; // 가로로 누울 수 있는 자리 수
    int column = 0; // 세로로 누울 수 있는 자리 수

    // 방 구조 저장할 2차원 배열 정의 후 값 입력
    String[][] room = new String[N][N];
    for (int i = 0; i < N; i++) {
      String[] line = br.readLine().split("");
      for (int j = 0; j < N; j++) {
        room[i][j] = line[j];
      }
    }

    // 가로 방향 확인
    for (int i = 0; i < N; i++) {
      int possible = 0; // 연속된 빈자리의 개수
      for (int j = 0; j < N; j++) {
        if (room[i][j].equals(".")) { // 빈자리면
          possible++; // 빈자리 개수 증가
          if (possible == 2) { // 길이가 2가 되면 가로로 누울 수 있는 자리
            row++;
          } 
        } else { // .이 아니면 연속된 빈자리의 개수 초기화
          possible = 0;
        }
      }
    }

    // 세로 방향 확인
    for (int i = 0; i < N; i++) {
      int possible = 0; // 연속된 빈자리의 개수
      for (int j = 0; j < N; j++) {
        if (room[j][i].equals(".")) { // 빈자리면
          possible++; // 빈자리 개수 증가
          if (possible == 2) { // 길이가 2가 되면 가로로 누울 수 있는 자리
            column++;
          } 
        } else { // .이 아니면 연속된 빈자리의 개수 초기화
          possible = 0;
        }
      }
    }

    System.out.println(row + " " + column);
  }
}