import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 약수의 개수 입력
    int[] divisors = new int[n];

    // 약수들 배열에 입력
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      divisors[i] = Integer.parseInt(st.nextToken());
    }

    // 오름차순 정렬 (최소값과 최대값 구하기 위함)
    Arrays.sort(divisors);

    // N = 최소값 x 최대값
    int N = divisors[0] * divisors[n - 1];
    System.out.println(N);
  }
}