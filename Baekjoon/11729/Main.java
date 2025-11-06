import java.io.*;

public class Main {

  static StringBuilder sb = new StringBuilder();

  // n개의 원판을 1번(from)에서 3번(to)으로 옮기기
  // via: 2번(임시)
  static void hanoi(int n, int from, int via, int to) {
    if (n == 1) {
      sb.append(from).append(' ').append(to).append("\n");
      return;
    }

    // 위의 n-1개를 2번으로 옮긴다.
    hanoi(n - 1, from, to, via);

    // 가장 큰 원판을 1번에서 2번으로 옮긴다.
    sb.append(from).append(' ').append(to).append("\n");

    // 2번에 있는 n-1개의 원판을 3번으로 옮긴다.
    hanoi(n - 1, via, from, to);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    // 하노이의 탑 최소 이동 횟수를 2^N - 1로 계산
    long count = 1;
    for (int i = 0; i < N; i++) {
      count *= 2;
    }
    count -= 1;

    sb.append(count).append("\n");
    
    hanoi(N, 1, 2, 3);

    System.out.println(sb.toString());
  }
}