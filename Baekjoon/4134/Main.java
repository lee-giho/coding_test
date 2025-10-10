import java.io.*;

public class Main {

  // 소수 확인하는 함수
  static boolean isPrime(long n) {
    if (n < 2) return false; // 0과 1은 소수 X
    if (n == 2) return true; // 2는 소수
    if (n % 2 == 0) return false; // 짝수는 소수 X

    long sqrt = (long) Math.sqrt(n);
    for (long i = 3; i <= sqrt; i += 2) {
      if (n % i == 0) return false; // 나누어떨어지면 합성수
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      long n = Long.parseLong(br.readLine());
      while (!isPrime(n)) { // n이 소수가 될 때까지 증가
        n++;
      }
      sb.append(n).append("\n");
    }
    
    System.out.println(sb.toString());
  }
}