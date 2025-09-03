import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine()); // 정수 N 입력받기

    StringTokenizer st = new StringTokenizer(br.readLine());

    long minValue = Long.MAX_VALUE; // 지금까지의 최솟값
    long best = 0; // 지금까지의 최대 (A[j] - A[i])

    for (int j = 1; j < N+1; j++) {
      long n = Long.parseLong(st.nextToken());

      if (j == 1) { // 첫 번째 원소에 대한 값 입력
        best = 0;
        minValue = n;
      } else {
        // 현재 인덱스에서 만들 수 있는 후보값 구하기
        long candidate = n - minValue;
        if (candidate > best) best = candidate;
        if (n < minValue) minValue = n;
      }

      sb.append(best);
      if (j < N) sb.append(" ");
    }

    System.out.println(sb);
  }
}