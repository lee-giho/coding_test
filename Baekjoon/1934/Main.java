import java.io.*;
import java.util.*;

public class Main {

  static int getGCD(int a, int b) { // 최대 공약수 계산 함수
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 입력

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken()); // 자연수 A 입력
      int B = Integer.parseInt(st.nextToken()); // 자연수 B 입력

      int gcd = getGCD(A, B); // 최대공약수 게산
      long lcm = (long) A * B / gcd; // 최소공배수 계산
      sb.append(lcm).append("\n");
    }

    System.out.println(sb.toString());
  }
}