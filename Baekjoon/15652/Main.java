import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static int[] arr; // 수열 저장
  static StringBuilder sb = new StringBuilder();

  // depth: 현재까지 채운 자리수 0 ~ M-1
  // start: 이번 자리에서 선택할 수 있는 최소 숫자
  static void dfs(int depth, int start) {
    // 길이 M짜리 수열을 완성한 경우
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(arr[i]).append(' ');
      }
      sb.append('\n');
      return;
    }

    // start ~ N까지 숫자를 depth 자리에 넣는다.
    for (int num = start; num < N+1; num++) {
      arr[depth] = num;
      dfs(depth+1, num); // 다음 자리 채우기
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    
    dfs(0, 1); // 0번째 자리부터 최소 1로 시작
    System.out.println(sb.toString());
  }
}