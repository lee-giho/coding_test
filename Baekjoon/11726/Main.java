import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 타일을 채울 가로 길이 n
    final int MOD = 10007; // 문제에서 요구한 나머지 연산 값

    // n = 1, n = 2일 때, 바로 답 출력 후 종료
    if (n < 3) {
      System.out.println(n);
      return;
    }

    int[] dp = new int[n+1];
    dp[1] = 1; // 2x1 보드를 채우는 경우: 세로 1
    dp[2] = 2; // 2x2 보드를 채우는 경우: 세로2 or 가로2

    // dp[i] = dp[i-1] + dp[i-2]
    for (int i = 3; i < n+1; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % MOD;
    }

    System.out.println(dp[n]);
  }
}