import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    boolean[] isPrime = new boolean[N + 1];
    Arrays.fill(isPrime, true); // 처음에 모든 수를 소수라고 가정
    isPrime[0] = false;
    isPrime[1] = false;

    // 에라토스테네스의 체
    for (int i = 2; i*i < N+1; i++) {
      if (isPrime[i]) {
        for (int j = i*i; j < N+1; j += i) {
          isPrime[j] = false; // 배수는 소수 X
        }
      }
    }

    // M 이상 N 이하의 소수 출력
    for (int i = M; i < N+1; i++) {
      if (isPrime[i]) {
        sb.append(i).append("\n");
      }
    }

    System.out.println(sb.toString());
  }
}