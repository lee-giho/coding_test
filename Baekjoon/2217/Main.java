import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 로프의 개수 N 입력

    // 각 로프가 버틸 수 있는 최대 중량을 저장할 배열
    int[] weight = new int[N];
    for (int i = 0; i < N; i++) {
      weight[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(weight);

    long answer = 0;

    // i번째 로프부터 끝까지 사용했을 때, 들 수 있는 최대 무게
    for (int i = 0; i < N; i++) {
      long canLift = 1L * weight[i] * (N-i);
      if (canLift > answer) {
        answer = canLift;
      }
    }

    System.out.println(answer);
  }
}