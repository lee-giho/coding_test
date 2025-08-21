import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int T = Integer.parseInt(br.readLine()); // Test case의 수 T를 입력받는다.
    
    for (int t = 0; t < T; t++) { // Test case의 수만큼 반복
      StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
      int N = Integer.parseInt(st.nextToken()); // 서쪽 사이트 개수 입력받기
      int M = Integer.parseInt(st.nextToken()); // 동쪽 사이트 개수 입력받기

      System.out.println(combination(M, N)); // combination 함수를 통해 경우의 수 출력
    }
  }

  // m개 중에서 n개를 고르는 조합 C(m, n)을 계산하는 함수
  public static int combination(int m, int n) {
    int[][] comb = new int[m+1][n+1]; // 조합 값 저장하는 2차원 배열

    for (int i = 0; i < m+1; i++) { // 0행 ~ m행까지 계산
      comb[i][0] = 1; // 0개를 선택하는 경우는 항상 1
      int maxJ = Math.min(i, n); // 현재 행에서 계산할 최대 열 번호

      if (i <= n) comb[i][i] = 1; // i개 중 i개 모두 선택하는 경우는 항상 1
      
      for (int j = 1; j < maxJ+1; j++) {
        if (j == i) continue; // 위의 조건문에서 처리했으므로 continue
        comb[i][j] = comb[i-1][j-1] + comb[i-1][j]; // 파스칼 법칙 적용
      }
    }
    return comb[m][n];
  }
}
