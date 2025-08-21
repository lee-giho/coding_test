import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 한 줄 단위로 입력값 입력 받음

    int T = Integer.parseInt(br.readLine()); // Test case의 수 T를 입력받는다.
    
    int[] Ns = new int[T]; // 서쪽에 있는 사이트 저장하는 배열
    int[] Ms = new int[T]; // 동쪽에 있는 사이트 저장하는 배열
    int maxN = 0, maxM = 0; // 테스트 케이스 중에 가장 큰 수를 저장하는 변수

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine()); // 공백을 기준으로 잘라주는 st 생성
      int N = Integer.parseInt(st.nextToken()); // 서쪽 사이트 개수 입력받기
      int M = Integer.parseInt(st.nextToken()); // 동쪽 사이트 개수 입력받기
      // 서쪽과 동쪽 사이트 저장
      Ns[t] = N; 
      Ms[t] = M;
      // 가장 큰 수인지 확인
      if (N > maxN) maxN = N;
      if (M > maxM) maxM = M;
    }

    int[][] comb = buildTriangle(maxM, maxN); // 가장 큰 수로 파스칼 삼각형 만들기

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int t = 0; t < T; t++) {
      bw.write(String.valueOf(comb[Ms[t]][Ns[t]])); // 경우의 수 버퍼에 저장
      bw.newLine(); // 줄바꿈
    }
    bw.flush(); // 버퍼에 저장되어 있는 문자열 출력
    bw.close(); // 스트림 종료
  }

  // 파스칼 삼각형 계산하는 함수
  // 가장 큰 수로 만들어서 다른 테스트 케이스에서도 추가적인 계산 없이 답을 구할 수 있다.
  public static int[][] buildTriangle(int m, int n) {
    int[][] comb = new int[m+1][n+1]; // 조합 값 저장하는 2차원 배열

    for (int i = 0; i < m+1; i++) {
      comb[i][0] = 1; // 0개를 선택하는 경우는 항상 1
      int maxJ = Math.min(i, n); // 현재 행에서 계산할 최대 열 번호

      if (i <= n) comb[i][i] = 1; // i개 중 i개 모두 선택하는 경우는 항상 1

      for (int j = 1; j < maxJ + 1; j++) {
        if (j == i) continue; // 위의 조건문에서 처리했으므로 continue
        comb[i][j] = comb[i-1][j-1] + comb[i-1][j]; // 파스칼 법칙 적용
      }
    }
    return comb;
  }
}
