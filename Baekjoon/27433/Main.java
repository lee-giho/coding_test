import java.io.*;

public class Main {

  // 재귀 함수로 팩토리얼 계산
  static long factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    System.out.println(factorial(N));
  }
}