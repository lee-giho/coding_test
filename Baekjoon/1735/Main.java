import java.io.*;
import java.util.*;

public class Main {

  // 유클리드 호제법으로 최대공약수 구하기
  static long gcd(long a, long b) {
    while (b != 0) {
      long temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 첫 번째 분수 A/B 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    // 두 번째 분수 C/D 입력
    st = new StringTokenizer(br.readLine());
    long C = Long.parseLong(st.nextToken());
    long D = Long.parseLong(st.nextToken());

    long num = A * D + C * B; // 분자
    long den = B * D; // 분모

    // 기약분수로 만들기 위해 최대공약수로 나누기
    long g = gcd(Math.abs(num), den);
    num /= g;
    den /= g;

    System.out.println(num + " " + den);
  }
}