import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 T 입력

    // 파도반 수열인 P 배열 초기화 및 3까지 입력
    long[] P = new long[101];
    P[1] = P[2] = P[3] = 1;

    // 점화식으로 4 ~ 100 계산
    // P[N] = P[N-3] + P[N-2]
    for (int i = 4; i < 101; i++) {
      P[i] = P[i-3] + P[i-2];
    }

    // 각 테스트 케이스의 값 처리
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      sb.append(P[N]).append("\n");
    }

    System.out.println(sb.toString());
  }
}