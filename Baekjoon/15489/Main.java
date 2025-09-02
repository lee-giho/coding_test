import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음
    StringTokenizer st = new StringTokenizer(br.readLine());

    int R = Integer.parseInt(st.nextToken()); // 시작 행 입력
    int C = Integer.parseInt(st.nextToken()); // 시작 열 입력
    int W = Integer.parseInt(st.nextToken()); // 삼각형 높이 입력

    int MAX = 30; // 최대 30행
    long[][] pascal = new long[MAX+1][MAX+1]; // 파스칼 삼각형을 저장할 배열

    // 파스칼 삼각형 생성
    for (int i = 1; i < MAX+1; i++) {
      pascal[i][1] = 1; // 각 행의 첫 번째 값은 1
      pascal[i][i] = 1; // 각 행의 마지막 값도 1
      for (int j = 2; j < i; j++) {
        pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
      }
    }

    // 삼각형 영역 합 구하기
    long sum = 0;
    for (int i = 0; i < W; i++) { // W행만큼 내려가며
      int row = R+i; // 현재 행 번호
      for (int j = 0; j < i+1; j++) { // 해당 행에서 C부터 C+1까지
        int col = C+j; // 현재 열 번호
        sum += pascal[row][col]; // 파스칼 값 더하기
      }
    }

    System.out.println(sum);
  }
}