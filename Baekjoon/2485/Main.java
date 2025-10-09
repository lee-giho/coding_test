import java.io.*;

public class Main {

  // 유클리드 호제법으로 최대공약수 구하기
  static int gcd(int a, int b) {
    while (b != 0) {
      int temp = a % b;
      a = b;
      b = temp;
    }
    return a;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 이미 심어져 있는 가로수의 수 N 입력

    // 심어져 있는 가로수의 위치 position 입력
    int[] position = new int[N];
    for (int i = 0; i < N; i++) {
      position[i] = Integer.parseInt(br.readLine());
    }

    // 인접한 가로수의 간격 계산
    int[] gaps = new int[N-1];
    for (int i = 0; i < N-1; i++) {
      gaps[i] = position[i+1] - position[i];
    }

    // 모든 간격의 최대공약수 구하기
    int GCD = gaps[0];
    for (int i = 1; i < gaps.length; i++) {
      GCD = gcd(GCD, gaps[i]);
    }

    // 추가해야 할 가로수의 수 더하기
    long count = 0;
    for (int gap : gaps) {
      count += (gap / GCD) - 1;
    }

    System.out.println(count);
  }
}