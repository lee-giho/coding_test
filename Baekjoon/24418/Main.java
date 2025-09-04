import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) { // 값을 사용하진 않고 받기만 함
      br.readLine();
    }

    long code1 = binom2nCn(n); // 코드1 실행 횟수
    long code2 = 1L * n * n; // 코드2 실행 횟수

    System.out.println(code1 + " " + code2);
  }

  private static long binom2nCn(int n) { // C(2n, n)
    long result = 1;
    for (int i = 1; i < n+1; i++) {
      result = result * (n+i) / i;
    }
    return result;
  }
}