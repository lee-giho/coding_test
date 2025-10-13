import java.io.*;
import java.util.*;

public class Main {

  // 에라토스테네스의 체로 [0, limit] 범위 소수 반환
  static boolean[] sieve(int limit) {
    boolean[] prime = new boolean[limit + 1];
    Arrays.fill(prime, true);
    if (limit >= 0) prime[0] = false;
    if (limit >= 1) prime[1] = false;

    for (int i = 2; i * i < limit + 1; i++) {
      if (prime[i]) {
        for (int j = i * i; j < limit + 1; j += i) {
          prime[j] = false;
        }
      }
    }
    return prime;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
    int[] queries = new int[T]; // 짝수 n을 입력받을 배열
    int maxN = 0;

    // 짝수 n 입력받기
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      queries[t] = N;
      if (N > maxN) {
        maxN = N;
      }
    }

    // 소수 전처리
    boolean[] isPrime = sieve(maxN);

    // 각 짝수 n에 대해 골드바흐 파티션 수 계산
    for (int n : queries) {
      int half = n / 2;
      int count = 0;
      for (int p = 2; p < half + 1; p++) {
        if (isPrime[p] && isPrime[n - p]) {
          count++;
        }
      }
      sb.append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}