import java.io.*;
import java.util.*;

public class Main {

  // 팩토리얼 계산 함수
  static int factorial(int n) {
    int result = 1;
    for (int i = 1; i < n + 1; i++) {
      result *= i;
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 자연수 N 입력
    int K = Integer.parseInt(st.nextToken()); // 정수 K 입력

    // 이항 계수 공식 적용
    int result = factorial(N) / (factorial(K) * factorial(N - K));

    System.out.println(result);
  }
}