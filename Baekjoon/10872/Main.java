import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine()); // 정수 N 입력

    int result = 1; // 팩토리얼 계산을 위한 초기값

    // 1부터 N까지 곱하며 팩토리얼 계산
    for (int i = 1; i < N + 1; i++) {
      result *= i;
    }

    System.out.println(result);
  }
}