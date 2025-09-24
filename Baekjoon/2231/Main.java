import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // N 입력
    int answer = 0; // 생성자 저장

    // 1부터 N까지 반복
    for (int i = 1; i < N; i++) {
      int sum = i; // 각 자리수의 합 저장

      // 각 자리수의 합 구하기
      int num = i;
      while (num != 0) {
        sum += num % 10; // 각 자리수 더하기
        num /= 10; // 자리수 줄이기
      }

      // 생성자 찾기
      if (sum == N) {
        answer = i;
        break;
      }
    }

    System.out.println(answer);
  }
}