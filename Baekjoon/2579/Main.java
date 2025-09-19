import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 계단 개수 입력

    // 각 계단의 점수 입력
    int[] score = new int[N+1];
    for (int i = 1; i < N+1; i++) {
      score[i] = Integer.parseInt(br.readLine());
    }

    // 계단 개수가 2 이하일 때 예외 처리
    if (N == 1) {
      System.out.println(score[1]);
      return;
    }
    if (N == 2) {
      System.out.println(score[1] + score[2]);
      return;
    }

    // 계단 개수가 3 이상일 때 dp 배열 초기화
    int[] dp = new int[N+1];
    dp[1] = score[1];
    dp[2] = score[1] + score[2];
    dp[3] = Math.max(score[1] + score[3], score[2] + score[3]);

    // 점화식 적용
    // dp[N] = max(dp[N-2] + score[N], dp[N-3] + score[N-1] + score[N])
    for (int i = 4; i < N+1; i++) {
      dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
    }

    System.out.println(dp[N]);
  }
}