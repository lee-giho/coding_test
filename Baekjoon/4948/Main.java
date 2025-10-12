import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    List<Integer> inputs = new ArrayList<>(); // 입력된 n 저장할 리스트

    // 여러 줄 입력받으며 0이 될 때까지 리스트에 저장
    int n;
    while ((n = Integer.parseInt(br.readLine())) != 0) {
      inputs.add(n);
    }

    int MaxN = Collections.max(inputs); // n들 중 최대값
    int limit = MaxN * 2; // 소수 판별 범위

    // 에라토스테네스의 체를 위한 배열 초기화
    boolean[] isPrime = new boolean[limit+1];
    Arrays.fill(isPrime, true);
    isPrime[0] = false;
    isPrime[1] = false;

    // 에라토스테네스의 체를 통해 i의 배수 제거
    for (int i = 2; i * i < limit + 1; i++) {
      if (isPrime[i]) {
        for (int j = i * i;  j < limit + 1; j += i) {
          isPrime[j] = false;
        }
      }
    }

    // 소수 개수 전처리
    int[] primeCount = new int[limit + 1];
    for (int i = 1; i < limit + 1; i++) {
      primeCount[i] = primeCount[i - 1] + (isPrime[i] ? 1 : 0);
    }

    // 각 n마다 (2, 2n] 구간의 소수 개수 계산
    for (int num : inputs) {
      int count = primeCount[num * 2] - primeCount[num];
      sb.append(count).append("\n");
    }

    System.out.println(sb.toString());
  }
}